package com.example.internetprojectpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internetprojectpractice.adapter.ShowGoodsAdapter;
import com.example.internetprojectpractice.decoration.SpacingItemDecoration;
import com.example.internetprojectpractice.dto.CarDto;
import com.example.internetprojectpractice.pojo.Address;
import com.example.internetprojectpractice.pojo.Goods;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class BuyGoodsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_title;
    private TextView tv_name_order;
    private TextView tv_phone_order;
    private TextView tv_address_order;
    private ListView lv_goods_container;
    private List<CarDto> carDtoList;
    private TextView tv_total_price;
    private OkHttpClient client;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_goods);

        client = new OkHttpClient.Builder().build();
        gson = new Gson();

        carDtoList = getIntent().getParcelableArrayListExtra("carDtoList");

        tv_title = findViewById(R.id.tv_title);
        tv_name_order = findViewById(R.id.tv_name_order);
        tv_phone_order = findViewById(R.id.tv_phone_order);
        tv_address_order = findViewById(R.id.tv_address_order);
        lv_goods_container = findViewById(R.id.lv_goods_container);
        tv_total_price = findViewById(R.id.tv_total_price);

        tv_title.setText("确认订单");

        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.ll_address_choice).setOnClickListener(this);
        findViewById(R.id.btn_settle).setOnClickListener(this);

        tv_total_price.setText(getTotalPrice());

        showGoodsList();
    }

//    获得总价
    private String getTotalPrice() {
        double totalPrice = 0;
        for (CarDto carDto : carDtoList) {
            totalPrice+=carDto.getPrice()*carDto.getNum();
        }
        return String.valueOf(totalPrice);
    }

    private void showGoodsList() {
        ShowGoodsAdapter adapter = new ShowGoodsAdapter(this,carDtoList);
        lv_goods_container.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_back) {
            finish();
        }
        if (v.getId() == R.id.ll_address_choice) {
            choiceAddress();
        }
        if (v.getId() == R.id.btn_settle) {
            buy();
        }
    }

    private void buy() {
        /*Request request = new Request.Builder()
                .url("")
                .build();*/
    }

    private void choiceAddress() {
        Intent intent = new Intent(this, ChoiceAddressActivity.class);
        startActivityForResult(intent, 1);
    }

    // 处理目标 Activity 返回的结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 检查请求码和结果码是否匹配
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // 获取返回的数据
            Address address = data.getParcelableExtra("address");
            // 处理返回的数据
            tv_name_order.setText(address.getName());
            tv_phone_order.setText(address.getPhone());
            tv_address_order.setText(address.getProvinceName() + " " +
                    address.getCityName() + " " +
                    address.getAreaName() + " " +
                    address.getAddress());
        }
    }


}