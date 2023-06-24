package com.example.internetprojectpractice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.dto.CarDto;

import java.util.List;

public class CartAdapter extends BaseAdapter {

    private final List<CarDto> mCarDtoList;
    private final Context mContext;
    private checkedChangeListener listener;



    public CartAdapter(Context mContext, List<CarDto> mCarDtoList) {
        this.mCarDtoList = mCarDtoList;
        this.mContext = mContext;
    }

    public void setOnCheckedListener(checkedChangeListener listener){
        this.listener = listener;
    }




    @Override
    public int getCount() {
        return mCarDtoList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCarDtoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;
        if (convertView==null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
            holder = new ViewHolder();
            holder.cb_check = convertView.findViewById(R.id.cb_check);
            holder.iv_thumb = convertView.findViewById(R.id.iv_thumb);
            holder.tv_name = convertView.findViewById(R.id.tv_name);
            holder.tv_price = convertView.findViewById(R.id.tv_price);
            holder.tv_sum = convertView.findViewById(R.id.tv_sum);
            holder.tv_count = convertView.findViewById(R.id.tv_count);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        CarDto carDto = mCarDtoList.get(position);
        holder.cb_check.setChecked(carDto.isChecked());
        holder.tv_name.setText(carDto.getTitle());
        holder.tv_price.setText(String.valueOf(carDto.getPrice()) );
        holder.tv_sum.setText(String.valueOf(carDto.getNum()*carDto.getPrice()));
        holder.tv_count.setText(String.valueOf(carDto.getNum()));
        holder.iv_thumb.setImageResource(R.drawable.xiaomi);
        holder.cb_check.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (listener!=null) {
                listener.onCheckedChanged(position,isChecked);
            }
        });
        return convertView;
    }

    public class ViewHolder {
        public CheckBox cb_check;
        public ImageView iv_thumb;
        public TextView tv_name;
        public TextView tv_price;
        public TextView tv_sum;
        public TextView tv_count;
    }

    public interface checkedChangeListener {
        void onCheckedChanged(int position, boolean isChecked);
    }



}
