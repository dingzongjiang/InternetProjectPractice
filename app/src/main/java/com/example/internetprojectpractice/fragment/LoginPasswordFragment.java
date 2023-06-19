package com.example.internetprojectpractice.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.RegisterMainActivity;

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
    private EditText et_phone;
    private Button btn_login;

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
        et_phone = view.findViewById(R.id.et_phone_login_password);
        et_password = view.findViewById(R.id.et_password_login);
        btn_login = view.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        Button btn_register = view.findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        String phone = et_phone.getText().toString();
        String password = et_password.getText().toString();
        if (v.getId() == R.id.btn_login) {
            if (phone.equals("")) {
                et_phone.setError("手机号不能为空");
            } else if (password.equals("")) {
                et_password.setError("密码不能为空");
            } else if (phone.length() != 11) {
                et_phone.setError("手机号长度不正确");
            } else if (password.length() < 6 || password.length() > 16) {
                et_password.setError("密码长度不能小于6位");
            } else {
                login(phone, password);
            }
        }
        if (v.getId() == R.id.btn_register) {
            Intent intent = new Intent(getActivity(), RegisterMainActivity.class);
            intent.putExtra("phone", phone);
            startActivity(intent);
        }
    }

    private boolean login(String phone, String password) {
        return false;
    }
}