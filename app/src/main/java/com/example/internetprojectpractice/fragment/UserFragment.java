package com.example.internetprojectpractice.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.internetprojectpractice.AddressManageActivity;
import com.example.internetprojectpractice.LoginMainActivity;
import com.example.internetprojectpractice.MainActivity2;
import com.example.internetprojectpractice.OrderManageActivity;
import com.example.internetprojectpractice.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SharedPreferences sharedPreferences;

    public UserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
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
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        sharedPreferences = getActivity().getSharedPreferences("userInfo", getActivity().MODE_PRIVATE);

        TextView tv_username = view.findViewById(R.id.tv_username);
        TextView tv_address_manage = view.findViewById(R.id.tv_address_manage);
        TextView tv_order_manage = view.findViewById(R.id.tv_order_manage);
        TextView tv_exit = view.findViewById(R.id.tv_exit);
        ImageView iv_head_image = view.findViewById(R.id.iv_head_image);

        if (sharedPreferences.contains("username")) {
            tv_username.setText(sharedPreferences.getString("username", ""));
        }

        tv_address_manage.setOnClickListener(this);
        tv_username.setOnClickListener(this);
        tv_order_manage.setOnClickListener(this);
        tv_exit.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        if (v.getId() == R.id.tv_username) {
            if (!sharedPreferences.contains("username")) {
                intent = new Intent(getActivity(), LoginMainActivity.class);
                startActivity(intent);
            }
        }
        if (v.getId() == R.id.tv_address_manage) {
            intent = new Intent(getActivity(), AddressManageActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.tv_order_manage) {
            intent = new Intent(getActivity(), OrderManageActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.tv_exit) {
            new AlertDialog.Builder(getActivity())
                    .setTitle("提示")
                    .setMessage("确定退出登录吗？")
                    .setPositiveButton("确定", (dialog, which) -> {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.commit();
                        Intent innerIntent = new Intent(getActivity(), MainActivity2.class);
                        startActivity(innerIntent);
                    })
                    .setNegativeButton("取消", null)
                    .show();
        }
    }
}