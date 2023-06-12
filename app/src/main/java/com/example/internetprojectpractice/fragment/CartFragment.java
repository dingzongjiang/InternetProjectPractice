package com.example.internetprojectpractice.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.adapter.ShoppingCartAdapter;
import com.example.internetprojectpractice.pojo.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
//        通过getShoppingCart()方法获取购物车中的商品信息
        List<Goods> goods = getShoppingCart();
//        找到购物车xml文件中没有商品时显示的控件
        LinearLayout ll_empty = view.findViewById(R.id.ll_empty);
        ListView lv_cart = view.findViewById(R.id.lv_cart);
        LinearLayout ll_bottom = view.findViewById(R.id.ll_bottom);
        view.findViewById(R.id.iv_cart).setVisibility(View.VISIBLE);
        view.findViewById(R.id.iv_back).setVisibility(View.GONE);
//        找到显示购物车中商品数量的控件
        TextView tv_count = view.findViewById(R.id.tv_count);
//        设置购物车中商品数量的显示，只在购物车模块中显示
        tv_count.setVisibility(View.VISIBLE);
//        设置购物车中商品数量的值
        tv_count.setText(String.valueOf(goods.size()));
//        下面两行是测试代码，测试完成后需要删除
        Goods goodsOne = new Goods();
        for (int i = 0; i < 10; i++) {
            goods.add(goodsOne);
        }

        if (goods.isEmpty() || goods == null) {
//            如果购物车中没有商品，则显示购物车为空的控件
            ll_empty.setVisibility(View.VISIBLE);
            ll_bottom.setVisibility(View.GONE);

        } else {
//            如果购物车中有商品，则隐藏购物车为空的控件
            ll_empty.setVisibility(View.GONE);
            ShoppingCartAdapter adapter = new ShoppingCartAdapter(getContext(), goods);
//            设置购物车中商品的适配器
            lv_cart.setAdapter(adapter);
        }
        return view;
    }

    private List<Goods> getShoppingCart() {
//        OkHttpClient client = new OkHttpClient();
        List<Goods> goodsList = new ArrayList<>();
        /*
        发送userID，然后后端返回该用户的购物车中所对应的商品信息
         */

        return goodsList;
    }


}