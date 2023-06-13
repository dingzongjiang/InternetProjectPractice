package com.example.internetprojectpractice.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.adapter.ItemLeftAdapter;
import com.example.internetprojectpractice.adapter.ShoppingHomeAdapter;
import com.example.internetprojectpractice.pojo.Goods;

import java.util.ArrayList;
import java.util.List;

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
        lv_item_left = view.findViewById(R.id.lv_item_left);
        gv_goods_right = view.findViewById(R.id.gv_goods_right);
        et_search = view.findViewById(R.id.et_search_category);
        btn_search = view.findViewById(R.id.btn_search_category);
        String[] items = {};
        ItemLeftAdapter itemLeftAdapter = new ItemLeftAdapter(getActivity(), items);
        List<Goods> goodsList = getGoodsList();
        ShoppingHomeAdapter homeAdapter = new ShoppingHomeAdapter(getActivity(), goodsList);
        lv_item_left.setAdapter(itemLeftAdapter);
        gv_goods_right.setAdapter(homeAdapter);
        btn_search.setOnClickListener(this);
        return view;
    }

    private List<Goods> getGoodsList() {
        List<Goods> goods = new ArrayList<>();
        return goods;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_search_category) {
            String search = et_search.getText().toString().trim();
            if (search.equals("")) {
                et_search.setError("请输入搜索内容");
            } else {
                /**
                 * 搜索功能
                 *
                 *
                 *
                 */
            }
        }
    }
}