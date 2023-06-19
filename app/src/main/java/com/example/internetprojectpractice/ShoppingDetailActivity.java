package com.example.internetprojectpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.internetprojectpractice.pojo.Goods;

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
        findViewById(R.id.btn_buy).setOnClickListener(this);

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
        Intent intent = getIntent();
//        Integer id = intent.getIntExtra("goods_id", 0);// 获取商品编号
        /**
         * 发送okhttp请求
         * getGoodsById(id)
         */
        tv_title.setText("商品详情");
        tv_goods_desc.setText("iphone12，苹果手机");
        tv_goods_price.setText("6666");
//        tv_count.setText("10");
        iv_goods_pic.setImageResource(R.drawable.iphone);
    }

    //    点击事件
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_back) {
            finish();
        }
        if (v.getId() == R.id.iv_cart) {
            Intent intent = new Intent(this, ShoppingCartActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btn_add_cart) {
            /**
             * 发送okhttp请求
             */
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = getLayoutInflater().inflate(R.layout.custom_dialog_layout, null);
            NumberPicker numberPicker = view.findViewById(R.id.numberPicker);
            numberPicker.setMaxValue(10);
            numberPicker.setMinValue(1);
            builder.setView(view);
            builder.setTitle("请选择你要添加的商品数量");
            builder.setPositiveButton("确定", (dialog, which) -> {
                int sum = numberPicker.getValue();
                addToCart(1);
            });
            builder.setNegativeButton("取消", null);
            builder.create().show();
        }
        if (v.getId() == R.id.btn_buy) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = getLayoutInflater().inflate(R.layout.custom_dialog_layout, null);
            NumberPicker numberPicker = view.findViewById(R.id.numberPicker);
            numberPicker.setMaxValue(10);
            numberPicker.setMinValue(1);
            builder.setView(view);
            builder.setTitle("请选择你要购买的商品数量");
            builder.setPositiveButton("确定", (dialog, which) -> {
                int sum = numberPicker.getValue();
                buyGoods(sum);
            });
            builder.setNegativeButton("取消", null);
            builder.create().show();
        }
    }

    private void buyGoods(int sum) {
        Intent intent = new Intent(this, BuyGoodsActivity.class);
        startActivity(intent);
    }

    /**
     * 将商品添加到购物车
     *
     * @param goodId,商品编号,也是需要在上述代码中传递的参数
     */
    private void addToCart(Integer goodId) {
        /**
         * 发送okhttp请求
         * 将商品添加到购物车,需要得到用户id，如果没有用户id，需要先登录
         */
    }

    private Goods getGoodsById(Integer id) {
        /**
         * 发送okhttp请求
         * 根据商品编号获取商品信息
         */
        return null;
    }


}