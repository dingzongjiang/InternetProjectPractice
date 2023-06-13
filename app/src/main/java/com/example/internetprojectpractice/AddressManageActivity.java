package com.example.internetprojectpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.internetprojectpractice.fragment.AddAddressFragment;
import com.example.internetprojectpractice.fragment.AddressManageFragment;

public class AddressManageActivity extends AppCompatActivity implements View.OnClickListener {

    private AddressManageFragment addressManageFragment;
    private AddAddressFragment addAddressFragment;
    private TextView tv_title;
    private TextView tv_option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_manage);

        tv_title = findViewById(R.id.tv_title);
        tv_option = findViewById(R.id.tv_option);
        tv_title.setText("地址管理");
        tv_option.setText("添加地址");

        initFragment();
        bindEvent();
    }


    public void initFragment(){
        addressManageFragment = new AddressManageFragment();
        addAddressFragment = new AddAddressFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fl_container_address, addressManageFragment, "addressManage");
        ft.add(R.id.fl_container_address, addAddressFragment, "addAddress");
        ft.show(addressManageFragment).hide(addAddressFragment);
        ft.commit();
    }

    public void bindEvent(){
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