package com.example.internetprojectpractice.fragment;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.ShoppingDetailActivity;
import com.example.internetprojectpractice.adapter.ItemLeftAdapter;
import com.example.internetprojectpractice.adapter.ShoppingHomeAdapter;
import com.example.internetprojectpractice.pojo.Category;
import com.example.internetprojectpractice.pojo.Goods;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView lv_item_left;
    private GridView gv_goods_right;
    private EditText et_search;
    private Button btn_search;
    private OkHttpClient client;
    private Gson gson;

    public CategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        client = new OkHttpClient.Builder().build();
        gson = new Gson();

        lv_item_left = view.findViewById(R.id.lv_item_left);
        gv_goods_right = view.findViewById(R.id.gv_goods_right);
        et_search = view.findViewById(R.id.et_search_category);
        btn_search = view.findViewById(R.id.btn_search_category);
        getCategoryData();

        getGoodsList();


        btn_search.setOnClickListener(this);
        return view;
    }

    private void getCategoryData() {
        Request request = new Request.Builder()
                .url("http://10.0.2.2:8080/category/by/android?id=0")
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
                        Type type = new TypeToken<List<Category>>() {
                        }.getType();
                        List<Category> categories = gson.fromJson(json, type);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                renderCategoryItem(categories);
                            }
                        });

                    } else {
                        System.out.println("请求失败,错误码为：" + response.code());
                    }
                } finally {
                    response.close();
                }
            }
        });
    }

    private void renderCategoryItem(List<Category> categories) {
        ItemLeftAdapter itemLeftAdapter = new ItemLeftAdapter(getActivity(), categories);
        lv_item_left.setAdapter(itemLeftAdapter);
        lv_item_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Category category = categories.get(position);
                int categoryId = category.getId();
                Request request = new Request.Builder()
                        .url("http://10.0.2.2:8080/product/category/" + categoryId)
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
                                Type type = new TypeToken<List<Goods>>() {
                                }.getType();
                                List<Goods> goods = gson.fromJson(json, type);
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        render(goods);
                                    }
                                });
                            } else {
                                System.out.println("请求失败,错误码为：" + response.code());
                            }
                        } finally {
                            response.close();
                        }
                    }
                });
            }
        });
    }

    private void render(List<Goods> goods) {
        ShoppingHomeAdapter homeAdapter = new ShoppingHomeAdapter(getActivity(), goods);
        gv_goods_right.setAdapter(homeAdapter);
        setGridViewMargin();
        gv_goods_right.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //点击商品跳转到商品详情页面
                Intent intent = new Intent(getActivity(), ShoppingDetailActivity.class);
                intent.putExtra("goods", goods.get(position));
                startActivity(intent);
            }
        });
    }


    private void getGoodsList() {
        Request request = new Request.Builder()
                .url("http://10.0.2.2:8080/product/all")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                System.out.println("请求失败");
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try {
                    if (response.isSuccessful()) {
                        String json = response.body().string();
                        Type type = new TypeToken<List<Goods>>() {
                        }.getType();
                        List<Goods> goods = gson.fromJson(json, type);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                render(goods);
                            }
                        });
                    } else {
                        System.out.println("请求失败,错误码为：" + response.code());
                    }
                } finally {
                    response.close();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_search_category) {
            String search = et_search.getText().toString().trim();
            if (search.equals("")) {
                et_search.setError("请输入搜索内容");
            } else {
                getGoodsByKeyword(search);
            }
        }
    }

    private void getGoodsByKeyword(String keyword) {
        Request request = new Request.Builder()
                .url("http://10.0.2.2:8080/product/search/"+keyword)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                System.out.println("请求失败");
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try {
                    if (response.isSuccessful()) {
                        String json = response.body().string();

                        Log.i(TAG, "我在这+onResponse: "+json);
                        Type type=new TypeToken<List<Goods>>(){}.getType();
                        List<Goods> goods = gson.fromJson(json, type);
                        getActivity().runOnUiThread(() -> render(goods));
                    }
                } finally {
                    response.close();
                }
            }
        });
    }

    private void setGridViewMargin() {
        for (int i = 0; i < gv_goods_right.getChildCount(); i++) {
            View childView = gv_goods_right.getChildAt(i);
            childView.setPadding(10, 10, 0, 10);
        }
    }

}