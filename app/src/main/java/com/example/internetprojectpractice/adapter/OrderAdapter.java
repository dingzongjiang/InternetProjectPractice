package com.example.internetprojectpractice.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.pojo.Goods;

import java.util.List;

public class OrderAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<Goods> mGoodsList;

    public OrderAdapter(Context mContext, List<Goods> mGoodsList) {
        this.mContext = mContext;
        this.mGoodsList = mGoodsList;
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
        ViewHolder holder=null;
        if (convertView==null) {
            holder=new ViewHolder();
            convertView=View.inflate(mContext, R.layout.item_order,null);
            holder.iv_thumb=convertView.findViewById(R.id.iv_thumb);
            holder.tv_goods_desc=convertView.findViewById(R.id.tv_goods_desc);
            holder.tv_goods_price=convertView.findViewById(R.id.tv_goods_price);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        Goods goods=mGoodsList.get(position);
        holder.tv_goods_desc.setText(goods.getTitle());
        holder.tv_goods_price.setText(String.valueOf(goods.getPrice()));
        holder.iv_thumb.setImageResource(R.drawable.xiaomi);
        return convertView;
    }

    public final class ViewHolder{
        public ImageView iv_thumb;
        public TextView tv_goods_desc;
        public TextView tv_goods_price;
    }
}
