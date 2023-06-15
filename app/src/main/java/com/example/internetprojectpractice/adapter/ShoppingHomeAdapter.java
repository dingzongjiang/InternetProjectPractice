package com.example.internetprojectpractice.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.pojo.Goods;

import java.util.List;

public class ShoppingHomeAdapter extends BaseAdapter {
    private final List<Goods> mGoodsList;
    private final Context mContext;


    public ShoppingHomeAdapter(Context context, List<Goods> goodsList){
        this.mContext = context;
        this.mGoodsList = goodsList;

    }

    @Override
    public int getCount() {
        return mGoodsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mGoodsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;
        if (convertView==null) {
            convertView=View.inflate(mContext, R.layout.item_goods,null);
            holder = new ViewHolder();
            holder.iv_thumb = convertView.findViewById(R.id.iv_thumb);
            holder.tv_name = convertView.findViewById(R.id.tv_name);
            holder.tv_price = convertView.findViewById(R.id.tv_price);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Goods goods = mGoodsList.get(position);

        holder.tv_name.setText(goods.getTitle());
        holder.tv_price.setText(String.valueOf(goods.getPrice()));
        holder.iv_thumb.setImageResource(R.drawable.xiaomi);

        return convertView;
    }

    public class ViewHolder {
        public ImageView iv_thumb;
        public TextView tv_name;
        public TextView tv_price;

    }



}
