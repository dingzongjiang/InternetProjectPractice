package com.example.internetprojectpractice;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShoppingCartActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout ll_cart;
    private TextView tv_total_price;
    private TextView tv_count;
    private LinearLayout ll_empty;
    private LinearLayout ll_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        TextView tv_title = findViewById(R.id.tv_title);
        tv_title.setText("购物车");


        tv_total_price = findViewById(R.id.tv_total_price);

        findViewById(R.id.iv_back).setOnClickListener(this);

        findViewById(R.id.btn_clear).setOnClickListener(this);

        findViewById(R.id.btn_settle).setOnClickListener(this);

        findViewById(R.id.btn_clear).setOnClickListener(this);

        ll_empty = findViewById(R.id.ll_empty);
        ll_content = findViewById(R.id.ll_content);

        tv_count = findViewById(R.id.tv_count);
//        然后需要从后端获取购物车中的商品数量，然后设置到tv_count中
        /**
         * 发送okhttp请求
         */
        tv_count.setText("10");

    }

    @Override
    protected void onResume() {
        super.onResume();
        showShoppingCart();
    }

    private void showShoppingCart() {
//        移除所有的子view
        ll_cart.removeAllViews();
//        从后端获取购物车中的商品列表
        /**
         * 发送okhttp请求
         */
        /**
         * 如果从后端发送过来的数据是空的，那么就显示空购物车
         */
        /*
        if (购物车中没有商品) {
            ll_empty.setVisibility(View.VISIBLE);
            ll_content.setVisibility(View.GONE);
            ll_cart.removeAllViews();
            return;}
        if (购物车中有商品) {
            ll_empty.setVisibility(View.GONE);
            ll_content.setVisibility(View.VISIBLE);
            接下面的遍历操作
         */

        for (int i = 0; i < 3; i++) {
            View view = View.inflate(this, R.layout.item_cart, null);
            ImageView iv_thumb = view.findViewById(R.id.iv_thumb);
            TextView tv_name = view.findViewById(R.id.tv_name);
            TextView tv_desc = view.findViewById(R.id.tv_desc);
            TextView tv_count = view.findViewById(R.id.tv_count);
            TextView tv_price = view.findViewById(R.id.tv_price);
            TextView tv_sum = view.findViewById(R.id.tv_sum);
            iv_thumb.setImageResource(R.drawable.iphone);
            tv_name.setText("iPhone 12");
            tv_desc.setText("iPhone 12 128G");
            tv_count.setText("1");
            tv_price.setText("8699");
            tv_sum.setText("8699");

//            给商品添加长按事件，长按删除商品
            view.setOnLongClickListener(v -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(ShoppingCartActivity.this);
                builder.setTitle("提示");
                builder.setMessage("确定要删除该商品吗？");
                builder.setPositiveButton("确定", (dialog, which) -> {
                    ll_cart.removeView(v);
//                从后端删除商品
//                该函数需要两个参数，一个是那位用户，另一个是那个商品
                    deleteGoodsFromShoppingCart();
                });
                builder.setNegativeButton("取消", null);
               builder.create().show();
                return true;
            });

//            给商品添加点击事件，点击进入商品详情页面
            view.setOnClickListener(v -> {
                Intent intent = new Intent(ShoppingCartActivity.this, ShoppingDetailActivity.class);
                intent.putExtra("goods_id", 1);
                startActivity(intent);
            });


            ll_cart.addView(view);
        }
//        可以在这个位置设置购物车的数量
//        计算总价
        refreshSum();
    }

    private void deleteGoodsFromShoppingCart() {
//        从后端删除商品
        /**
         * 发送okhttp请求
         */

//        showShoppingCart();

    }

    private void refreshSum() {
        double sum = 0;
        for (int i = 0; i < ll_cart.getChildCount(); i++) {
            View childView = ll_cart.getChildAt(i);
            TextView tv_sum = childView.findViewById(R.id.tv_sum);
            sum += Double.parseDouble(tv_sum.getText().toString());
        }
        tv_total_price.setText(sum+"");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_back) {
            finish();
        }
        if (v.getId() == R.id.btn_clear) {
            clearShoppingCart();
        }
        if(v.getId() == R.id.btn_settle){
            settle();
        }
    }
//    结算
    private void settle(){
//        从后端获取购物车中的商品列表
//        然后将购物车里的商品添加到订单表中，然后删除购物车中的商品
        /**
         * 发送okhttp请求
         */
    }

    //    清空购物车
    private void clearShoppingCart() {
//        从后端清空购物车,删除该用户在购物车表中的所有记录
        /**
         * 发送okhttp请求
         */
//        然后在这里设置购物车的数量为0，然后刷新购物车
        showShoppingCart();
    }
}