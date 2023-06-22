package com.example.internetprojectpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BuyGoodsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_title;
    private TextView tv_name_order;
    private TextView tv_phone_order;
    private TextView tv_address_order;
    private RecyclerView rv_goods_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_goods);


        tv_title = findViewById(R.id.tv_title);
        tv_name_order = findViewById(R.id.tv_name_order);
        tv_phone_order = findViewById(R.id.tv_phone_order);
        tv_address_order = findViewById(R.id.tv_address_order);
        rv_goods_container = findViewById(R.id.rv_goods_container);

        tv_title.setText("确认订单");

        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.ll_address_choice).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_back) {
            finish();
        }
        if (v.getId() == R.id.ll_address_choice) {
            showAddressDialog();
        }
    }

    private void showAddressDialog() {
        /*View view = View.inflate(this, R.layout.dialog_address, null);
        EditText et_name = view.findViewById(R.id.et_name);
        EditText et_phone = view.findViewById(R.id.et_phone);
        EditText et_address = view.findViewById(R.id.et_address);
        TextView tv_cancel = view.findViewById(R.id.tv_cancel);
        TextView tv_confirm = view.findViewById(R.id.tv_confirm);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        tv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString().trim();
                String phone = et_phone.getText().toString().trim();
                String address = et_address.getText().toString().trim();
                tv_name_order.setText(name);
                tv_phone_order.setText(phone);
                tv_address_order.setText(address);
                dialog.dismiss();
            }
        });*/
    }
}