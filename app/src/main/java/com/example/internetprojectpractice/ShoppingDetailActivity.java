package com.example.internetprojectpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShoppingDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_title;
    private TextView tv_count;
    private TextView tv_goods_price;
    private TextView tv_goods_desc;
    private ImageView iv_goods_pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_detail);
        tv_title = findViewById(R.id.tv_title);
        tv_count = findViewById(R.id.tv_count);
        tv_goods_price = findViewById(R.id.tv_goods_price);
        tv_goods_desc = findViewById(R.id.tv_goods_desc);
        iv_goods_pic = findViewById(R.id.iv_goods_pic);
        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.iv_cart).setOnClickListener(this);
        findViewById(R.id.btn_add_cart).setOnClickListener(this);


    }
//      onResume()方法是Activity生命周期中的一个回调方法，
//      当Activity从不可见状态变为可见状态时，会调用该方法。
    @Override
    protected void onResume() {
        super.onResume();
        showDetail();
    }

//    展示商品详情
    private void showDetail() {
        showTvCount();
        Intent intent = getIntent();
        Integer id = intent.getIntExtra("goods_id",0);// 获取商品编号
        /**
         * 发送okhttp请求
         */
        tv_title.setText("商品详情");
        tv_goods_desc.setText("iphone12，苹果手机");
        tv_goods_price.setText("6666");
//        tv_count.setText("10");
        iv_goods_pic.setImageResource(R.drawable.iphone);
    }

//    展示购物车中的商品数量
    private void showTvCount() {
        /**
         * 发送okhttp请求
         * 从后端获取购物车中的商品数量，然后设置到tv_count中
         */

    }

//    点击事件
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.iv_back){
            finish();
        }
        if(v.getId() == R.id.iv_cart){
            Intent intent = new Intent(this,ShoppingCartActivity.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.btn_add_cart){
            /**
             * 发送okhttp请求
             */
            addToCart(1);
        }
    }

    /**
     * 将商品添加到购物车
     * @param goodId,商品编号,也是需要在上述代码中传递的参数
     */
    private void addToCart(Integer goodId) {
        /**
         * 发送okhttp请求
         * 将商品添加到购物车
         */
    }
}