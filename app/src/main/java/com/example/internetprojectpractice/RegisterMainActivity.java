package com.example.internetprojectpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.internetprojectpractice.utils.GetViewMaxLength;
import com.example.internetprojectpractice.utils.HindTextWatcher;

public class RegisterMainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, View.OnFocusChangeListener {

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
    private boolean isExistUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_main);
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
        et_phone_number.addTextChangedListener(new HindTextWatcher(this,et_phone_number, GetViewMaxLength.getMaxLength(et_phone_number)));
//        给按钮添加点击事件
        btn_register.setOnClickListener(this);
        btn_get_verifycode.setOnClickListener(this);

//        给RadioGroup设置监听器，使用setOnCheckedChangeListener方法
        rg_gender.setOnCheckedChangeListener(this);

//        给et_username添加焦点失去事件，使用setOnFocusChangeListener()方法
        et_username.setOnFocusChangeListener(this);

    }




    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_register_register){

        }
        if(v.getId()==R.id.btn_get_verifycode_register){
            /**
             * 从后端得到验证码
             */
            verifyCode="123456";
            /*if(!et_verifycode.getText().toString().equals(verifyCode)){
                Toast.makeText(this, "验证码错误", Toast.LENGTH_SHORT).show();
                return;
            }*/
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId==R.id.radio_male){
            gender="男";
        }
        if (checkedId==R.id.radio_female){
            gender="女";
        }
    }

//    判断输入的信息是否合法
    private boolean judgeMessageLegal(){




        if(et_phone_number.getText().toString().length()<11){
            Toast.makeText(this, "手机号码小于11位", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * 在这个方法中当鼠标一处et_username时，有后端检验是否有相同用户名
     * @param v The view whose state has changed.
     * @param hasFocus The new focus state of v.
     */
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(v.getId()==R.id.et_username){
            if(!hasFocus){
                /**
                 * 从后端接受一个布尔类型的数据,决定提示框是否要出现
                 */
                isExistUsername = false;
//                flag=后端的代码返回值;
               /* if(flag){
                    hintUsernameError.setText("");
//                    View.GONE--不可见，  View.INVISIBLE--可见
                    hintUsernameError.setVisibility(View.GONE);
                }*/

            }
        }
    }
}