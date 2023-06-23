package com.example.internetprojectpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.internetprojectpractice.fragment.AddAddressFragment;
import com.example.internetprojectpractice.fragment.AddressManageFragment;

public class AddressManageActivity extends AppCompatActivity implements View.OnClickListener {

    public AddressManageFragment addressManageFragment;
    private AddAddressFragment addAddressFragment;
    private TextView tv_title;
    private TextView tv_option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_manage);

        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);

        if (!sharedPreferences.contains("username")) {
            new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage("请先登录")
                    .setPositiveButton("确定", (dialog, which) -> {
                        Intent intent = new Intent(this, LoginMainActivity.class);
                        startActivity(intent);
                    })
                    .setNegativeButton("取消", (dialog, which) -> {
                        finish();
                    })
                    .show();
            return;
        }

        tv_title = findViewById(R.id.tv_title);
        tv_option = findViewById(R.id.tv_option);
        tv_title.setText("地址管理");
        tv_option.setText("添加地址");

        initFragment();
        bindEvent();
    }


    public void initFragment() {
        addressManageFragment = new AddressManageFragment();
        addAddressFragment = new AddAddressFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fl_container_address, addressManageFragment, "addressManage");
        ft.add(R.id.fl_container_address, addAddressFragment, "addAddress");
        ft.show(addressManageFragment).hide(addAddressFragment);
        ft.commit();
    }

    public void bindEvent() {
        tv_option.setOnClickListener(this);
        findViewById(R.id.iv_back).setOnClickListener(this);
        tv_title.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_option) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.show(addAddressFragment).hide(addressManageFragment);
            ft.commit();
        }
        if (v.getId() == R.id.iv_back) {
            finish();
        }
        if (v.getId() == R.id.tv_title) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.show(addressManageFragment).hide(addAddressFragment);
            ft.commit();
        }
    }
}