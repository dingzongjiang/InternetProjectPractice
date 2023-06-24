package com.example.internetprojectpractice.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.ShoppingDetailActivity;
import com.example.internetprojectpractice.dto.CarDto;
import com.example.internetprojectpractice.dto.CarDto;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private final List<CarDto> mCarDtoList;
    private checkedChangeListener listener;

    public CartAdapter(List<CarDto> mCarDtoList) {
        this.mCarDtoList = mCarDtoList;
    }
    public void setOnCheckedListener(checkedChangeListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        CarDto carDto = mCarDtoList.get(position);
        holder.tv_name.setText(carDto.getTitle());
        holder.tv_price.setText(String.valueOf(carDto.getPrice()));
        holder.tv_sum.setText(carDto.getNum());
        holder.tv_count.setText(String.valueOf(carDto.getPrice()*carDto.getNum()));
        holder.iv_thumb.setImageResource(R.drawable.xiaomi);
        holder.cb_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                carDto.setChecked(isChecked);
                listener.onCheckedChanged(holder.getBindingAdapterPosition(),isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCarDtoList.size();
    }

    // 获取被选中的项


    public class ViewHolder extends RecyclerView.ViewHolder {
        public CheckBox cb_check;
        public ImageView iv_thumb;
        public TextView tv_name;
        public TextView tv_price;
        public TextView tv_sum;
        public TextView tv_count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cb_check = itemView.findViewById(R.id.cb_check);
            iv_thumb = itemView.findViewById(R.id.iv_thumb);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_sum = itemView.findViewById(R.id.tv_sum);
            tv_count = itemView.findViewById(R.id.tv_count);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = getAdapterPosition();
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle("删除")
                            .setMessage("确定删除该商品吗？")
                            .setPositiveButton("确定", (dialog, which) -> {
                                mCarDtoList.remove(position);
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position, mCarDtoList.size() - position);
                            })
                            .setNegativeButton("取消", (dialog, which) -> {
                            })
                            .show();
                    return false;
                }
            });

            /*cb_check.setOnCheckedChangeListener((buttonView, isChecked) -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    // 处理复选框的事件
                    // isChecked表示复选框的选中状态
                    // 根据需要执行相应的操作，例如更新数据或处理选中状态
                    cb_check.setChecked(isChecked);
                    listener.onCheckedChanged(position, isChecked);
                }
            });*/
        }

    }

    public interface checkedChangeListener {
        void onCheckedChanged(int position, boolean isChecked);
    }

}
