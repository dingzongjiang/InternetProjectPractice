package com.example.internetprojectpractice.fragment;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internetprojectpractice.BuyGoodsActivity;
import com.example.internetprojectpractice.LoginMainActivity;
import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.adapter.CartAdapter;
import com.example.internetprojectpractice.decoration.SpacingItemDecoration;
import com.example.internetprojectpractice.dto.CarDto;
import com.example.internetprojectpractice.pojo.Goods;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Serializable;
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
    private ListView lv_cart;
    private LinearLayout ll_empty;
    private LinearLayout ll_bottom;
    private Button btn_settle;
    private OkHttpClient client;
    private Gson gson;
    private SharedPreferences sharedPreferences;
    private TextView tv_count;
    private ArrayList<CarDto> selectedCarDtoList;
    private TextView tv_total_price;

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

        sharedPreferences = getActivity().getSharedPreferences("userInfo",
                getActivity().MODE_PRIVATE);

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

        selectedCarDtoList = new ArrayList<>();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
//        通过getShoppingCart()方法获取购物车中的商品信息
//        List<Goods> goods = getShoppingCart();
//        找到购物车xml文件中没有商品时显示的控件
        ll_empty = view.findViewById(R.id.ll_empty);
        lv_cart = view.findViewById(R.id.lv_cart);
        ll_bottom = view.findViewById(R.id.ll_bottom);
        btn_settle = view.findViewById(R.id.btn_settle);
        tv_total_price = view.findViewById(R.id.tv_total_price);

        view.findViewById(R.id.iv_cart).setVisibility(View.VISIBLE);
        view.findViewById(R.id.iv_back).setVisibility(View.GONE);
//        找到显示购物车中商品数量的控件
        tv_count = view.findViewById(R.id.tv_count);
//        设置购物车中商品数量的显示，只在购物车模块中显示
        tv_count.setVisibility(View.VISIBLE);
//        设置购物车中商品数量的值
//        tv_count.setText(String.valueOf(goods.size()));


        System.out.println("我到这儿来了，我是购物车");
        /*List<CarDto> carDtoList = new ArrayList<>();
        carDtoList.add(new CarDto("1",1,"1","1","1",1));

        render(carDtoList);*/

        getShoppingCart();
        btn_settle.setOnClickListener(this);
        return view;
    }

    private void render(List<CarDto> cartDtoList) {
        CartAdapter adapter = new CartAdapter(getActivity(), cartDtoList);
        lv_cart.setAdapter(adapter);
        adapter.setOnCheckedListener((position, isChecked) -> {
            CarDto carDto = cartDtoList.get(position);
            System.out.println("我被点击了,我是" + carDto.getPid());
            carDto.setChecked(isChecked);
            if (isChecked==true) {
                System.out.println("我被选中了,我是" + carDto.getPid());
                selectedCarDtoList.add(carDto);
                showTotalPrice();
            } else {
                System.out.println("我被取消选中了,我是" + carDto.getPid());
                selectedCarDtoList.remove(carDto);
                showTotalPrice();
            }
        });
    }

    private void showTotalPrice() {
        double totalPrice = 0;
        for (CarDto carDto : selectedCarDtoList) {
            totalPrice += carDto.getPrice() * carDto.getNum();
        }
        tv_total_price.setText(String.valueOf(totalPrice));
    }


    private void getShoppingCart() {
        Request request = new Request.Builder()
                .addHeader("token", sharedPreferences.getString("token", ""))
                .url("http://10.0.2.2:8080/car/getCars")
                .get()
                .build();
        System.out.println("我到这儿来了，我是getShoppingCart()，request=" + request);

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
                        Type type = new TypeToken<List<CarDto>>() {
                        }.getType();
                        List<CarDto> carDtoList = gson.fromJson(json, type);
                        System.out.println("我到这儿来了，我是购物车，carDtoList=" + carDtoList);
                        getActivity().runOnUiThread(() -> render(carDtoList));
                    }
                } finally {
                    response.close();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_settle) {
            new AlertDialog.Builder(getActivity())
                    .setTitle("提示")
                    .setMessage("是否确认购买？")
                    .setPositiveButton("确定", (dialog, which) -> {
                        Intent intent = new Intent(getActivity(), BuyGoodsActivity.class);
                        intent.putParcelableArrayListExtra("carDtoList",selectedCarDtoList);
                        startActivity(intent);
                    })
                    .setNegativeButton("取消", null)
                    .show();
        }
    }
}