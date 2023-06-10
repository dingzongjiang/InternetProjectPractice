package com.example.internetprojectpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ShoppingChannelActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_count;
    private GridLayout gl_channel;
    private Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_channel);
//        获取布局文件中的控件，注意该控件是多用的，在不同的布局中内容是不一样的
        TextView tv_title = findViewById(R.id.tv_title);
//        设置标题
        tv_title.setText("手机商城");
//        获取购物车中的商品数量控件
        tv_count = findViewById(R.id.tv_count);
//        获取网格布局控件
        gl_channel = findViewById(R.id.gl_channel);

        btn_add = findViewById(R.id.btn_add);
        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.iv_cart).setOnClickListener(this);
//        展示商品
        showGoods();
    }

    private void showGoods() {
        // 商品条目是一个线性布局，设置布局的宽度为屏幕的一半
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(screenWidth / 2, LinearLayout.LayoutParams.WRAP_CONTENT);
//        List<Goods> goodsList = getGoods();
//        System.out.println(goodsList);
        for (int i = 0; i < 10; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_goods, null);
            ImageView iv_thumb = view.findViewById(R.id.iv_thumb);
            TextView tv_name = view.findViewById(R.id.tv_name);
            TextView tv_price = view.findViewById(R.id.tv_price);
            view.findViewById(R.id.btn_add).setOnClickListener(v -> {
                /*
                添加购物车时注意，先判断该用户是否已经添加了该商品，如果已经添加了，则更新数量，否则添加新的记录


                 */
                addCart(tv_name.getText().toString(), tv_price.getText().toString());
            });
            iv_thumb.setImageResource(R.drawable.iphone);
            tv_name.setText("iPhone 12");
            tv_price.setText("8888");

            btn_add.setOnClickListener(v -> {
//                在这里应该传输的是商品的id与用户的id
                addCart(tv_name.getText().toString(), tv_price.getText().toString());
            });

//            给ImageView设置点击事件
            iv_thumb.setOnClickListener(v -> {
//                跳转到商品详情页面,在这里应该传输的是商品的id等重要的信息
                Intent intent = new Intent(ShoppingChannelActivity.this, ShoppingDetailActivity.class);
//                商品id是最重要的，因为在商品详情页面需要根据商品id查询商品的详细信息
                intent.putExtra("id", 1);
                intent.putExtra("name", tv_name.getText().toString());
                intent.putExtra("price", tv_price.getText().toString());
                intent.putExtra("desc", "这是一款很好的手机");
                intent.putExtra("thumb", R.drawable.iphone);
                startActivity(intent);
            });


            gl_channel.addView(view, params);
        }
    }


    private void addCart(String name, String price) {

        /**
         * 1. 先判断该用户是否已经添加了该商品，如果已经添加了，则更新数量，否则添加新的记录
         * queryCart(Integer uid, Integer pid)
         * 2. 如果添加成功，则更新购物车中的商品数量
         * 3. 如果添加失败，则提示用户
         *
         */
        //        insertCart()
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_back) {
            finish();
        }
        if (v.getId() == R.id.iv_cart) {
            // 跳转到购物车页面
            Intent intent = new Intent(this, ShoppingCartActivity.class);
//            该标志位表示清除该页面之上的所有页面
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}