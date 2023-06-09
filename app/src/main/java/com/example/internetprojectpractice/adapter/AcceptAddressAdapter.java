package com.example.internetprojectpractice.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.UpdateAddressActivity;
import com.example.internetprojectpractice.pojo.Address;

import java.io.Serializable;
import java.util.List;

public class AcceptAddressAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<Address> mAddressList;

    public AcceptAddressAdapter(Context mContext, List<Address> mAddressList) {
        this.mContext = mContext;
        this.mAddressList = mAddressList;
    }

    @Override
    public int getCount() {
        return mAddressList.size();
    }

    @Override
    public Object getItem(int position) {
        return mAddressList.get(position);
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
            convertView = View.inflate(mContext, R.layout.item_address, null);
            holder.tv_name = convertView.findViewById(R.id.tv_name);
            holder.tv_phone = convertView.findViewById(R.id.tv_phone);
            holder.tv_address = convertView.findViewById(R.id.tv_address);
            holder.btn_edit = convertView.findViewById(R.id.btn_edit);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Address address = mAddressList.get(position);
        holder.tv_name.setText(address.getName());
        holder.tv_phone.setText(address.getPhone());
        holder.tv_address.setText(address.getProvinceName() + " " +
                address.getCityName() + " " +
                address.getAreaName() + " " +
                address.getAddress());
        holder.btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, UpdateAddressActivity.class);
                intent.putExtra("address", address);
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }

    public final class ViewHolder {
        public TextView tv_name;
        public TextView tv_phone;
        public TextView tv_address;
        public Button btn_edit;

    }
}
