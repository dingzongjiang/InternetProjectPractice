package com.example.internetprojectpractice;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.internetprojectpractice.pojo.User;
import com.example.internetprojectpractice.utils.GetViewMaxLength;
import com.example.internetprojectpractice.utils.HindTextWatcher;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterMainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg_gender;
    private Button btn_register;
    private Button btn_get_verifycode;
    private EditText et_username;
    private EditText et_password;
    private EditText et_phone_number;
    private EditText et_email;
    private EditText et_verifycode;
    private String gender;
    private String verifyCode;
    private TextView hintUsernameError;
    private boolean flag;
    private final boolean isExistUsername = false;
    private OkHttpClient client;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_main);

        client = new OkHttpClient.Builder().build();
        gson = new Gson();

//        获取控件
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_phone_number = findViewById(R.id.et_phone_number);
        et_email = findViewById(R.id.et_email);
        hintUsernameError = findViewById(R.id.hintUsernameError);
        et_verifycode = findViewById(R.id.et_verifycode);
        rg_gender = findViewById(R.id.rg_gender);
        btn_register = findViewById(R.id.btn_register_register);
        btn_get_verifycode = findViewById(R.id.btn_get_verifycode_register);


//        给电话号码，验证码，密码设置最长输入长度
        et_phone_number.addTextChangedListener(new HindTextWatcher(this, et_phone_number, GetViewMaxLength.getMaxLength(et_phone_number)));
        et_password.addTextChangedListener(new HindTextWatcher(this, et_password, GetViewMaxLength.getMaxLength(et_password)));
        et_verifycode.addTextChangedListener(new HindTextWatcher(this, et_password, GetViewMaxLength.getMaxLength(et_verifycode)));

//        给按钮添加点击事件
        btn_register.setOnClickListener(this);
        btn_get_verifycode.setOnClickListener(this);

//        给RadioGroup设置监听器，使用setOnCheckedChangeListener方法
        rg_gender.setOnCheckedChangeListener(this);

//        给et_username添加焦点失去事件，使用setOnFocusChangeListener()方法
//        et_username.setOnFocusChangeListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_register_register) {
            String username = et_username.getText().toString();
            String password = et_password.getText().toString();
            String phone = et_phone_number.getText().toString();
            String email = et_email.getText().toString();
            String verifyCode = et_verifycode.getText().toString();
            Integer sex = gender.equals("男") ? 1 : 0;
            if (judgeMessageLegal()) {
                User user = new User(username, password, phone, email, sex);
                String json = gson.toJson(user);
                RequestBody requestBody = RequestBody.create(json,
                        MediaType.parse("application/json; charset=utf-8"));
                Request request = new Request.Builder()
                        .url("http://10.0.2.2:8080/user/register")
                        .post(requestBody)
                        .build();
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        if (response.isSuccessful()) {
                            String result = response.body().string();
                            boolean flag = Boolean.parseBoolean(result);
                            if (flag) {
                                runOnUiThread(() -> {
                                    new AlertDialog.Builder(RegisterMainActivity.this)
                                            .setTitle("注册成功")
                                            .setMessage("恭喜您注册成功")
                                            .setPositiveButton("确定", (dialog, which) -> {
                                                Intent intent = new Intent(RegisterMainActivity.this, LoginMainActivity.class);
                                                intent.putExtra("username", username);
                                                intent.putExtra("password", password);
                                                startActivity(intent);
                                            })
                                            .create()
                                            .show();
                                });

                            } else {
                                runOnUiThread(() -> new AlertDialog.Builder(RegisterMainActivity.this)
                                        .setTitle("注册失败")
                                        .setMessage("注册失败，请重新注册")
                                        .setPositiveButton("确定", null)
                                        .create()
                                        .show());
                            }
                        }
                    }
                });

            } else {

            }
        }
        if (v.getId() == R.id.btn_get_verifycode_register) {
            /**
             * 从后端得到验证码
             */
            verifyCode = "123456";
            /*if(!et_verifycode.getText().toString().equals(verifyCode)){
                Toast.makeText(this, "验证码错误", Toast.LENGTH_SHORT).show();
                return;
            }*/
//            将后端中获得的验证码以弹窗形式发送到界面中
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("验证码");
            builder.setMessage(verifyCode);
            builder.setPositiveButton("确定", null);
            builder.create().show();

        }
    }

    /**
     * @param group     the group in which the checked radio button has changed
     * @param checkedId the unique identifier of the newly checked radio button
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.radio_male) {
            gender = "男";
        }
        if (checkedId == R.id.radio_female) {
            gender = "女";
        }
    }

    //    判断输入的信息是否合法
    private boolean judgeMessageLegal() {
        if (isExistUsername) {
            Toast.makeText(this, "用户名已存在，请再此次输入一个新的用户名", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (et_password.getText().toString().length() < 6) {
            Toast.makeText(this, "密码小于6位，请重新输入密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (et_phone_number.getText().toString().length() < 11) {
            Toast.makeText(this, "手机号码小于11位", Toast.LENGTH_SHORT).show();
            return false;
        }
        /*if (et_verifycode.getText().toString().equals(verifyCode)) {
            Toast.makeText(this, "验证码错误，请重新获取验证码", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }

    /**
     * 在这个方法中当鼠标一处et_username时，有后端检验是否有相同用户名
     * @param v The view whose state has changed.
     * @param hasFocus The new focus state of v.
     */


}