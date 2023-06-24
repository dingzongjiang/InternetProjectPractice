package com.example.internetprojectpractice.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.dto.CarDto;

import java.util.List;

public class ShowGoodsAdapter extends BaseAdapter {
    private final List<CarDto> mCardtoList;
    private final Context mContext;

    public ShowGoodsAdapter(Context mContext, List<CarDto> mCardtoList) {
        this.mContext = mContext;
        this.mCardtoList = mCardtoList;
    }

    @Override
    public int getCount() {
        return mCardtoList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCardtoList.get(position);
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
            holder.tv_goods_count=convertView.findViewById(R.id.tv_goods_count);
            holder.tv_goods_total_price=convertView.findViewById(R.id.tv_goods_total_price);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        CarDto carDto=mCardtoList.get(position);
        holder.tv_goods_desc.setText(carDto.getTitle());
        holder.tv_goods_price.setText(String.valueOf(carDto.getPrice()));
        holder.tv_goods_count.setText(String.valueOf(carDto.getNum()));
        holder.tv_goods_total_price.setText(String.valueOf(carDto.getPrice()*carDto.getNum()));
        holder.iv_thumb.setImageResource(R.drawable.xiaomi);
        return convertView;
    }

    public class ViewHolder {
        ImageView iv_thumb;
        TextView tv_goods_desc;
        TextView tv_goods_price;
        TextView tv_goods_count;
        TextView tv_goods_total_price;
    }
}
