package com.example.internetprojectpractice.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.ShoppingDetailActivity;
import com.example.internetprojectpractice.pojo.Goods;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private final List<Goods> mGoodsList;

    public CartAdapter(List<Goods> mGoodsList) {
        this.mGoodsList = mGoodsList;
    }


    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        Goods goods = mGoodsList.get(position);
        holder.tv_name.setText(goods.getTitle());
        holder.tv_desc.setText("");
        holder.tv_price.setText(String.valueOf(goods.getPrice()));
        holder.tv_sum.setText(String.valueOf(goods.getPrice()));
        holder.tv_count.setText("1");
        holder.iv_thumb.setImageResource(R.drawable.xiaomi);
    }

    @Override
    public int getItemCount() {
        return mGoodsList.size();
    }

    // 获取被选中的项
    public List<Goods> getSelectedItems() {
        List<Goods> selectedItems = new ArrayList<>();
        for (Goods goods : mGoodsList) {
            if (goods.isChecked) {
                selectedItems.add(goods);
            }
        }
        return selectedItems;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CheckBox cb_check;
        public ImageView iv_thumb;
        public TextView tv_name;
        public TextView tv_desc;
        public TextView tv_price;
        public TextView tv_sum;
        public TextView tv_count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cb_check = itemView.findViewById(R.id.cb_check);
            iv_thumb = itemView.findViewById(R.id.iv_thumb);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_sum = itemView.findViewById(R.id.tv_sum);
            tv_count = itemView.findViewById(R.id.tv_count);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Goods goods = mGoodsList.get(position);
                    Intent intent = new Intent(itemView.getContext(), ShoppingDetailActivity.class);
                    intent.putExtra("goods", goods.getId());
                    itemView.getContext().startActivity(intent);
                }
            });

            cb_check.setOnCheckedChangeListener((buttonView, isChecked) -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    // 处理复选框的事件
                    // isChecked表示复选框的选中状态
                    // 根据需要执行相应的操作，例如更新数据或处理选中状态
                    cb_check.setChecked(isChecked);
                }
            });
        }

    }
}
