package com.example.internetprojectpractice.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.internetprojectpractice.LoginForgetActivity;
import com.example.internetprojectpractice.MainActivity2;
import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.RegisterMainActivity;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginPasswordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginPasswordFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText et_password;
    private EditText et_username;
    private Button btn_login;
    private OkHttpClient client;
    private SharedPreferences sharedPreferences;
    private Gson gson;

    public LoginPasswordFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginPasswordFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginPasswordFragment newInstance(String param1, String param2) {
        LoginPasswordFragment fragment = new LoginPasswordFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_password, container, false);

        Intent intent = getActivity().getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");


        client = new OkHttpClient.Builder().build();
        gson = new Gson();

        et_username = view.findViewById(R.id.et_username_login_password);
        et_password = view.findViewById(R.id.et_password_login);
        btn_login = view.findViewById(R.id.btn_login);

        if (username != null) et_username.setText(username);
        if (password != null) et_password.setText(password);

        btn_login.setOnClickListener(this);
        Button btn_register = view.findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);

        view.findViewById(R.id.btn_forget).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();
        if (v.getId() == R.id.btn_login) {
            if (username.equals("")) {
                et_username.setError("用户名不能为空");
            } else if (password.equals("")) {
                et_password.setError("密码不能为空");
            } else if (password.length() < 6) {
                et_password.setError("密码长度不能小于6位");
            } else {
                login(username, password);
            }
        }
        if (v.getId() == R.id.btn_register) {
            Intent intent = new Intent(getActivity(), RegisterMainActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        }

        if (v.getId() == R.id.btn_forget) {
            Intent intent = new Intent(getActivity(), LoginForgetActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        }
    }

    private boolean login(String username, String password) {

        Request request = new Request.Builder()
                .url("http://10.0.2.2:8080/user/login?username=" + username + "&password=" + password)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try {
                    if (response.isSuccessful()) {
                        String json = response.body().string();
                        if (json == "用户不存在") {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("登录失败")
                                            .setMessage("用户不存在")
                                            .setPositiveButton("确定", null)
                                            .show();
                                }
                            });
                        } else if (json == "密码错误") {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("登录失败")
                                            .setMessage("密码错误")
                                            .setPositiveButton("确定", null)
                                            .show();
                                }
                            });
                        } else {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("登录成功")
                                            .setMessage("开启美好的购物之旅吧")
                                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    writeSystem(username, password, json);
                                                    Intent intent = new Intent(getActivity(), MainActivity2.class);
                                                    startActivity(intent);
                                                }
                                            })
                                            .show();
                                }
                            });
                        }

                    }
                } finally {
                    response.close();
                }
            }
        });

        return false;
    }

    private void writeSystem(String username, String password, String Token) {
        sharedPreferences = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.putString("token", Token);
        editor.apply();
    }
}