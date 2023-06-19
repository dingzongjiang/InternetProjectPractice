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
 * Use the {@link LoginVerifyCodeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginVerifyCodeFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText et_phone;
    private EditText et_verifycode;
    private Button btn_login;
    private Button btn_register;

    public LoginVerifyCodeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginVerifyCodeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginVerifyCodeFragment newInstance(String param1, String param2) {
        LoginVerifyCodeFragment fragment = new LoginVerifyCodeFragment();
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
        View view = inflater.inflate(R.layout.fragment_login_verify_code, container, false);
        et_phone = view.findViewById(R.id.et_phone_login_verifycode);
        et_verifycode = view.findViewById(R.id.et_verify_code);
        btn_login = view.findViewById(R.id.btn_login_verifycode);
        btn_register = view.findViewById(R.id.btn_register_verifycode);
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        String phone = et_phone.getText().toString();
        String verifyCode = et_verifycode.getText().toString();
        if (v.getId() == R.id.btn_login_verifycode) {
            if (phone.equals("")) {
                et_phone.setError("手机号码不能为空");
            } else if (phone.length() != 11) {
                et_phone.setError("手机号码格式不正确");
            } else if (verifyCode.equals("")) {
                et_verifycode.setError("验证码不能为空");
            } else if (verifyCode.length() != 6) {
                et_verifycode.setError("验证码格式不正确");
            }else {
                login(phone,verifyCode);
            }
        }
        if (v.getId() == R.id.btn_register_verifycode) {
            Intent intent = new Intent(getActivity(), RegisterMainActivity.class);
//            intent.putExtra("phone",phone);
            startActivity(intent);
        }
    }

    private boolean login(String phone, String verifyCode) {
        return false;
    }

}