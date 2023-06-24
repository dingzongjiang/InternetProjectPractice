package com.example.internetprojectpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.internetprojectpractice.dto.CarDto;
import com.example.internetprojectpractice.pojo.Cart;
import com.example.internetprojectpractice.pojo.Goods;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ShoppingDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_title;
    private TextView tv_count;
    private TextView tv_goods_price;
    private TextView tv_goods_desc;
    private ImageView iv_goods_pic;
    private Goods goods;
    private SharedPreferences sharedPreferences;
    private OkHttpClient client;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_detail);

        client = new OkHttpClient.Builder().build();
        gson = new Gson();

        sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);

        tv_title = findViewById(R.id.tv_title);
        tv_count = findViewById(R.id.tv_count);
        tv_goods_price = findViewById(R.id.tv_goods_price);
        tv_goods_desc = findViewById(R.id.tv_goods_desc);
        iv_goods_pic = findViewById(R.id.iv_goods_pic);


        findViewById(R.id.iv_back).setOnClickListener(this);
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
        goods = getIntent().getParcelableExtra("goods");
        tv_title.setText("商品详情");
        tv_goods_desc.setText(goods.getTitle());
        tv_goods_price.setText(String.valueOf(goods.getPrice()));
        iv_goods_pic.setImageResource(R.drawable.iphone);
    }

    //    点击事件
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_back) {
            finish();
        }
        if (v.getId() == R.id.btn_add_cart) {
            boolean flag = isLogin();
            if (flag) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View view = getLayoutInflater().inflate(R.layout.custom_dialog_layout, null);
                NumberPicker numberPicker = view.findViewById(R.id.numberPicker);
                numberPicker.setMaxValue(10);
                numberPicker.setMinValue(1);
                builder.setView(view);
                builder.setTitle("请选择你要添加的商品数量");
                builder.setPositiveButton("确定", (dialog, which) -> {
                    int num = numberPicker.getValue();
                    addToCart(num);
                    startActivity(new Intent(this, MainActivity2.class));
                });
                builder.setNegativeButton("取消", null);
                builder.create().show();
            } else {
                new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("请先登录")
                        .setPositiveButton("确定", (dialog, which) -> {
                            Intent intent = new Intent(this, LoginMainActivity.class);
                            startActivity(intent);
                        })
                        .setNegativeButton("取消", null)
                        .create()
                        .show();
            }
        }
        if (v.getId() == R.id.btn_buy) {
            if (isLogin()) {
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
            } else {
                new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("请先登录")
                        .setPositiveButton("确定", (dialog, which) -> {
                            Intent intent = new Intent(this, LoginMainActivity.class);
                            startActivity(intent);
                        })
                        .setNegativeButton("取消", null)
                        .create()
                        .show();
            }
        }
    }

    private boolean isLogin() {
        return sharedPreferences.contains("username");
    }

    private void buyGoods(int sum) {
        Intent intent = new Intent(this, BuyGoodsActivity.class);
        ArrayList<CarDto> carDtoList = new ArrayList<>();
        CarDto carDto = new CarDto();
        carDto.setPid(String.valueOf(goods.getId()));
        carDto.setNum(sum);
        carDto.setTitle(goods.getTitle());
        carDto.setPrice(goods.getPrice());
        carDtoList.add(carDto);
        intent.putParcelableArrayListExtra("carDtoList", carDtoList);
        startActivity(intent);
    }

    /**
     * 添加到购物车
     *
     * @param sum
     */
    private void addToCart(int sum) {
        Cart cart = new Cart();
        cart.setPid(goods.getId());
        cart.setNum(sum);
        cart.setPrice((int) goods.getPrice());

        String json = gson.toJson(cart);
        System.out.println("我写的json："+json);
        RequestBody requestBody = RequestBody.create(json,
                MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .addHeader("token", sharedPreferences.getString("token", ""))
                .post(requestBody)
                .url("http://10.0.2.2:8080/car/createCar")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try {
                    if (response.isSuccessful()) {
                        String result = response.body().string();
                        boolean flag = Boolean.parseBoolean(result);
                        if (flag) {
                            runOnUiThread(() -> {
                                new AlertDialog.Builder(ShoppingDetailActivity.this)
                                        .setTitle("提示")
                                        .setMessage("添加成功")
                                        .setPositiveButton("确定", null)
                                        .create()
                                        .show();

                            });
                        } else {
                            runOnUiThread(() -> {
                                new AlertDialog.Builder(ShoppingDetailActivity.this)
                                        .setTitle("提示")
                                        .setMessage("添加失败")
                                        .setPositiveButton("确定", null)
                                        .create()
                                        .show();
                            });
                        }
                    }
                } finally {
                    response.close();
                }
            }
        });
    }
}