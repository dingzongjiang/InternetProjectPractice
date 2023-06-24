package com.example.internetprojectpractice;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.internetprojectpractice.adapter.ChoiceAddressAdapter;
import com.example.internetprojectpractice.decoration.SpacingItemDecoration;
import com.example.internetprojectpractice.pojo.Address;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ChoiceAddressActivity extends AppCompatActivity {


    private OkHttpClient client;
    private Gson gson;
    private SharedPreferences sharedPreferences;
    private ListView lv_address_choice_container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_address);
        System.out.println("我在ChoiceAddressActivity");

        client = new OkHttpClient.Builder().build();
        gson = new Gson();
        sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);

        TextView tv_title = findViewById(R.id.tv_title);
        lv_address_choice_container = findViewById(R.id.lv_address_choice_container);
        tv_title.setText("选择地址");
        findViewById(R.id.iv_back).setOnClickListener(v -> finish());

        getAddress();

    }

    private void getAddress() {
        Request request = new Request.Builder()
                .addHeader("token", sharedPreferences.getString("token", ""))
                .get()
                .url("http://10.0.2.2:8080/address")
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
                        String json = response.body().string();
                        Type type = new TypeToken<List<Address>>() {
                        }.getType();
                        List<Address> addressList = gson.fromJson(json, type);
                        render(addressList);
                    }
                } finally {
                    response.close();
                }
            }
        });
    }

    private void render(List<Address> addressList) {
        System.out.println("我在render, addressList数据是: " + addressList);
        ChoiceAddressAdapter adapter = new ChoiceAddressAdapter(addressList,ChoiceAddressActivity.this);
        lv_address_choice_container.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Address address = addressList.get(position);
                System.out.println("我在onItemClick, address数据是: " + address);
//                adapter.notifyDataSetChanged();
                setResult(RESULT_OK, getIntent().putExtra("address", address));
                finish();
            }
        });
       /* LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv_address_choice_container.setLayoutManager(layoutManager);*/
        /*rv_address_choice_container.setAdapter(adapter);
        rv_address_choice_container.setLayoutManager(new LinearLayoutManager(this));
        rv_address_choice_container.addItemDecoration(new SpacingItemDecoration(10));*/
        lv_address_choice_container.setAdapter(adapter);
//        System.out.println("我在设置布局管理器");
    }
}