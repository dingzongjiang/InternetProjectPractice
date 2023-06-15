package com.example.internetprojectpractice.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.pojo.Goods;

import java.util.List;

public class ShoppingCartAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<Goods> mCartList;

    public ShoppingCartAdapter(Context mContext, List<Goods> mCartList) {
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
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView=View.inflate(mContext, R.layout.item_cart,null);
            holder.iv_thumb = convertView.findViewById(R.id.iv_thumb);
            holder.tv_name = convertView.findViewById(R.id.tv_name);
            holder.tv_desc = convertView.findViewById(R.id.tv_desc);
            holder.tv_price = convertView.findViewById(R.id.tv_price);
            holder.tv_sum = convertView.findViewById(R.id.tv_sum);
            holder.tv_count = convertView.findViewById(R.id.tv_count);
            holder.cb_check = convertView.findViewById(R.id.cb_check);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Goods goods = mCartList.get(position);
        holder.tv_name.setText(goods.getTitle());
        holder.tv_desc.setText("");
        holder.tv_price.setText(String.valueOf(goods.getPrice()));
        holder.tv_sum.setText(String.valueOf(goods.getPrice()));
        holder.tv_count.setText("1");
        holder.iv_thumb.setImageResource(R.drawable.xiaomi);

        holder.cb_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                goods.setIsChecked(isChecked);
            }
        });
        return convertView;
    }



    public final class ViewHolder {
        public CheckBox cb_check;
        public ImageView iv_thumb;
        public TextView tv_name;
        public TextView tv_desc;
        public TextView tv_price;
        public TextView tv_sum;
        public TextView tv_count;
    }

}
