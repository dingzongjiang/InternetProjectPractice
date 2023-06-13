package com.example.internetprojectpractice;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.internetprojectpractice.adapter.OrderAdapter;
import com.example.internetprojectpractice.pojo.Goods;

import java.util.ArrayList;
import java.util.List;

public class OrderManageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_manage);
        ListView lv_order = findViewById(R.id.lv_order);
        List<Goods> goodsList = getGoodsList();
//        以下代码是为了测试，实际上应该从数据库中获取数据
        Goods goods = new Goods();
        for (int i = 0; i < 10; i++) {
            goods.setTitle("小米手机");
            goods.setPrice(3654);
            goodsList.add(goods);
        }
        OrderAdapter adapter = new OrderAdapter(this, goodsList);
        lv_order.setAdapter(adapter);
    }

    private List<Goods> getGoodsList() {
        List<Goods> goodsList = new ArrayList<>();
        return goodsList;
    }
}