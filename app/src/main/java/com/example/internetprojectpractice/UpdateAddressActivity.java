package com.example.internetprojectpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.internetprojectpractice.pojo.Address;

import java.io.Serializable;

public class UpdateAddressActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_name_update;
    private EditText et_province_update;
    private EditText et_city_update;
    private EditText et_area_update;
    private EditText et_address_update;
    private EditText et_phone_update;
    private Button btn_update_address;
    private TextView tv_title;
    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_address);

        Address address = getIntent().getParcelableExtra("address");

        tv_title = findViewById(R.id.tv_title);
        iv_back = findViewById(R.id.iv_back);
        et_name_update = findViewById(R.id.et_name_update);
        et_province_update = findViewById(R.id.et_address_province_update);
        et_city_update = findViewById(R.id.et_address_city_update);
        et_area_update = findViewById(R.id.et_address_area_update);
        et_address_update = findViewById(R.id.et_address_update);
        et_phone_update = findViewById(R.id.et_phone_update);
        btn_update_address = findViewById(R.id.btn_update_address);

        tv_title.setText("修改地址");
        et_name_update.setText(address.getName());
        et_province_update.setText(address.getProvinceName());
        et_city_update.setText(address.getCityName());
        et_area_update.setText(address.getAreaName());
        et_address_update.setText(address.getAddress());
        et_phone_update.setText(address.getPhone());

        iv_back.setOnClickListener(this);
        btn_update_address.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_update_address) {
            String name = et_name_update.getText().toString();
            String province = et_province_update.getText().toString();
            String city = et_city_update.getText().toString();
            String area = et_area_update.getText().toString();
            String detailAddress = et_address_update.getText().toString();
            String phone = et_phone_update.getText().toString();
            Address address = new Address(name, province, city, area, detailAddress, phone);
        }
        if (v.getId() == R.id.iv_back) {
            finish();
        }
    }
}