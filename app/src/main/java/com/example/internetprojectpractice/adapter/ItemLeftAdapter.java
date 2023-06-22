package com.example.internetprojectpractice.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.pojo.Category;

import java.util.List;

public class ItemLeftAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<Category> mCategoryList;

    public ItemLeftAdapter(Context mContext, List<Category> mCategoryList) {
        this.mContext = mContext;
        this.mCategoryList = mCategoryList;
    }

    @Override
    public int getCount() {
        return mCategoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCategoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.item_left, null);
            holder.tv_item = convertView.findViewById(R.id.tv_item_left);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_item.setText(mCategoryList.get(position).getName());
        return convertView;
    }

    private class ViewHolder {
        private TextView tv_item;
    }
}
