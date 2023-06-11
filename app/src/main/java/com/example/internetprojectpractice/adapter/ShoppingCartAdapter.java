package com.example.internetprojectpractice.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.internetprojectpractice.pojo.Cart;
import com.example.internetprojectpractice.pojo.Goods;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartAdapter extends BaseAdapter {
    private Context mContext;
    private List<Cart> mCartList;

    public ShoppingCartAdapter(Context mContext, List<Cart> mCartList) {
        this.mContext = mContext;
        this.mCartList = mCartList;
    }

    @Override
    public int getCount() {
        return mCartList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCartList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return convertView;
    }

    private class ViewHolder{
    }


    private  List<Goods> getCartGoods(){
        List<Goods> goodsList = new ArrayList<>();

        for (int i = 0; i < mCartList.size(); i++) {
            /**
             * 发送okhttp请求
             *
             */

        }

        return goodsList;
    }

}
