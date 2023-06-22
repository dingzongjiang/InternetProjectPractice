package com.example.internetprojectpractice;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.internetprojectpractice.fragment.LoginPasswordFragment;
import com.example.internetprojectpractice.fragment.LoginVerifyCodeFragment;
import com.example.internetprojectpractice.utils.ViewUtil;

public class LoginMainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    public static String username=null;
    private TextView tv_login_password;
    private CheckBox cb_remember;
    private Button btn_forget;
    private EditText et_password;
    private EditText et_phone;
    private ActivityResultLauncher<Intent> register;
    private Button btn_login;
    private RadioButton rb_password;
    private RadioButton rb_verifycode;
    private Button btn_register;
    private LoginVerifyCodeFragment loginVerifyCodeFragment;
    private LoginPasswordFragment loginPasswordFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        RadioGroup rg_login = findViewById(R.id.rg_login);
        rb_password = findViewById(R.id.rb_password);
        rb_verifycode = findViewById(R.id.rb_verifycode);
        rg_login.setOnCheckedChangeListener(this);
        initFragment();
    }

    private void initFragment() {
        loginPasswordFragment = new LoginPasswordFragment();
        loginVerifyCodeFragment = new LoginVerifyCodeFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fl_login_container, loginPasswordFragment, "loginPasswordFragment");
        ft.add(R.id.fl_login_container, loginVerifyCodeFragment, "loginVerifyCodeFragment");
        ft.show(loginPasswordFragment).hide(loginVerifyCodeFragment);
        ft.commit();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (checkedId == R.id.rb_password) {
            ft.show(loginPasswordFragment).hide(loginVerifyCodeFragment);
        }
        if (checkedId == R.id.rb_verifycode) {
            ft.show(loginVerifyCodeFragment).hide(loginPasswordFragment);
        }
        ft.commit();
    }

    //    定义一个内部类，用于获得文本框的最大输入长度
    public int getMaxLength(EditText et) {
        InputFilter[] filters = et.getFilters();
        for (InputFilter filter : filters) {
            if (filter instanceof InputFilter.LengthFilter) {
                int maxLength = ((InputFilter.LengthFilter) filter).getMax();
                return maxLength;
            }
        }
        return 0;
    }

    //    定义一个内部类，用于监听手机号码输入框的输入内容
    private class HindTextWatcher implements TextWatcher {
        private EditText mView;
        private int maxLength;

        public HindTextWatcher(EditText mView, int maxLength) {
            this.mView = mView;
            this.maxLength = maxLength;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        //        输入框内容的长度等于最大长度时，隐藏输入法
        @Override
        public void afterTextChanged(Editable s) {
//            获取输入框中的内容
            String phoneNumber = s.toString();
//          如果输入框中的内容长度等于最大长度，隐藏输入法
            if (phoneNumber.length() == maxLength) {
                ViewUtil.hideInputMethod(LoginMainActivity.this, mView);
            }
        }
    }


}