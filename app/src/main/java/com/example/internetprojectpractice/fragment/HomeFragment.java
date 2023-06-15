package com.example.internetprojectpractice.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.ShoppingDetailActivity;
import com.example.internetprojectpractice.adapter.ShoppingHomeAdapter;
import com.example.internetprojectpractice.pojo.Goods;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText et_input_search;
    private Button btn_search;
    private List<Goods> goodsList;
    private GridView gv_channel;
    private OkHttpClient client;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        view.findViewById(R.id.iv_back).setVisibility(View.GONE);

        btn_search = view.findViewById(R.id.btn_search);
        et_input_search = view.findViewById(R.id.et_input_search);
        gv_channel = view.findViewById(R.id.gv_channel);
        goodsList = getShoppingList();
        btn_search.setOnClickListener(this);
//        以下是测试数据，后期需要删除
        Goods goods = new Goods("小米", 6999.99);
        for (int i = 0; i < 10; i++) {
            goodsList.add(goods);
        }


        if (goodsList == null || goodsList.isEmpty()) {
            new AlertDialog.Builder(getActivity())
                    .setTitle("提示")
                    .setMessage("你输入的关键字没有找到相关商品")
                    .setPositiveButton("确定", null)
                    .create()
                    .show();
        } else {
            ShoppingHomeAdapter adapter = new ShoppingHomeAdapter(getActivity(), goodsList);
            gv_channel.setAdapter(adapter);
            gv_channel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    点击商品跳转到商品详情页面
                    Intent intent = new Intent(getActivity(), ShoppingDetailActivity.class);
                    Goods goods = (Goods) parent.getItemAtPosition(position);
                    intent.putExtra("goods", String.valueOf(goods));
                    startActivity(intent);
                }
            });
            setGridViewMargin();
        }
        return view;
    }


    @Override
    public void onClick(View v) {
//        查询按钮点击事件
        if (v.getId() == R.id.btn_search) {
            String keyword = et_input_search.getText().toString();
//
            if (keyword.equals("")) {
                et_input_search.setError("请输入有效的字段");
            } else {
                goodsList = getShoppingListByKeyword(keyword);
            }
        }
    }

    //查询商品列表
    private List<Goods> getShoppingList() {
        /*
        1. 获取商品列表
        2. 将商品列表展示在GridView中
        3.发送okhttp请求
         */
//        client = new OkHttpClient().newBuilder().build();

        List<Goods> goods = new ArrayList<>();

        return goods;
    }

    //通过关键词查询商品列表
    private List<Goods> getShoppingListByKeyword(String keyword) {
        /*
        1. 通过关键字获取商品列表
        2. 将商品列表展示在GridView中
        3.发送okhttp请求
         */
        List<Goods> goods = new ArrayList<>();

        return goods;
    }

//    给GridView设置外边距

    private void setGridViewMargin() {
        for (int i = 0; i < gv_channel.getChildCount(); i++) {
            View childView = gv_channel.getChildAt(i);
            childView.setPadding(10, 10, 10, 10);
        }
    }

}