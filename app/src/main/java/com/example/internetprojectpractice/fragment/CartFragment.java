package com.example.internetprojectpractice.fragment;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internetprojectpractice.LoginMainActivity;
import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.adapter.CartAdapter;
import com.example.internetprojectpractice.decoration.SpacingItemDecoration;
import com.example.internetprojectpractice.dto.CarDto;
import com.example.internetprojectpractice.pojo.Goods;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView rv_cart;
    private List<Goods> selectedItems;
    private LinearLayout ll_empty;
    private LinearLayout ll_bottom;
    private Button btn_settle;
    private OkHttpClient client;
    private Gson gson;
    private SharedPreferences sharedPreferences;

    public CartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
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

        sharedPreferences = getActivity().getSharedPreferences("userInfo",getActivity().MODE_PRIVATE);

        if (!sharedPreferences.contains("username")) {
            Log.i(TAG, "我被初始化了");
            new AlertDialog.Builder(getActivity())
                    .setTitle("提示")
                    .setMessage("请先登录")
                    .setPositiveButton("确定", (dialog, which) -> {
                        Intent intent = new Intent(getActivity(), LoginMainActivity.class);
                        startActivity(intent);
                    })
                    .setNegativeButton("取消", null)
                    .show();
        }

        client = new OkHttpClient.Builder().build();
        gson = new Gson();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
//        通过getShoppingCart()方法获取购物车中的商品信息
//        List<Goods> goods = getShoppingCart();
//        找到购物车xml文件中没有商品时显示的控件
        ll_empty = view.findViewById(R.id.ll_empty);
        rv_cart = view.findViewById(R.id.rv_cart);
        ll_bottom = view.findViewById(R.id.ll_bottom);
        btn_settle = view.findViewById(R.id.btn_settle);
        view.findViewById(R.id.iv_cart).setVisibility(View.VISIBLE);
        view.findViewById(R.id.iv_back).setVisibility(View.GONE);
//        找到显示购物车中商品数量的控件
        TextView tv_count = view.findViewById(R.id.tv_count);
//        设置购物车中商品数量的显示，只在购物车模块中显示
        tv_count.setVisibility(View.VISIBLE);
//        设置购物车中商品数量的值
//        tv_count.setText(String.valueOf(goods.size()));
////        下面两行是测试代码，测试完成后需要删除
//        Goods goodsOne = new Goods("xiaomi",6233);
//        for (int i = 0; i < 10; i++) {
//            goods.add(goodsOne);
//        }
        CarDto carDto = new CarDto(1,"小米",1699);
        List<CarDto> carDtoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            carDtoList.add(carDto);
        }

        System.out.println("我到这儿来了，我是购物车");
//        render(carDtoList);

        btn_settle.setOnClickListener(this);
        return view;
    }

    private void render(List<CarDto> cartDtoList) {
        if (cartDtoList == null ||cartDtoList.isEmpty()) {
//            如果购物车中没有商品，则显示购物车为空的控件
            ll_empty.setVisibility(View.VISIBLE);
            ll_bottom.setVisibility(View.GONE);
        } else {
//            如果购物车中有商品，则隐藏购物车为空的控件
            ll_empty.setVisibility(View.GONE);
//            ShoppingCartAdapter adapter = new ShoppingCartAdapter(getActivity(), goods);
//            设置购物车中商品的适配器
            CartAdapter adapter = new CartAdapter(cartDtoList);
//            System.out.println("我到这儿来了，我是渲染函数，adapter="+adapter.toString());
            rv_cart.setAdapter(adapter);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            rv_cart.setLayoutManager(layoutManager);
            rv_cart.addItemDecoration(new SpacingItemDecoration(5));
//            System.out.println("我到这儿来了，我是渲染函数，现在要设置监听器");

            adapter.setOnCheckedListener((position, isChecked) -> {
                CarDto carDto = cartDtoList.get(position);
                carDto.setChecked(isChecked);
            });
        }
    }


    private void getShoppingCart() {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_settle) {
            new AlertDialog.Builder(getActivity())
                    .setTitle("提示")
                    .setMessage("是否确认购买？")
                    .setPositiveButton("确定", (dialog, which) -> {

                    })
                    .setNegativeButton("取消", null)
                    .show();


        }
    }
}