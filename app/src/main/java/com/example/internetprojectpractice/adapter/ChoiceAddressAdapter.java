package com.example.internetprojectpractice.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.pojo.Address;

import java.util.List;

public class ChoiceAddressAdapter extends BaseAdapter {
    private final List<Address> addressList;
    private final Context mContext;



    public ChoiceAddressAdapter(List<Address> addressList, Context mContext) {
        this.addressList = addressList;
        this.mContext = mContext;
    }



    @Override
    public int getCount() {
        return addressList.size();
    }

    @Override
    public Object getItem(int position) {
        return addressList.get(position);
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
            convertView = View.inflate(mContext, R.layout.item_choice_address, null);
            holder.tv_name = convertView.findViewById(R.id.tv_name_choice);
            holder.tv_phone = convertView.findViewById(R.id.tv_phone_choice);
            holder.tv_address = convertView.findViewById(R.id.tv_address_choice);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Address address = addressList.get(position);
        holder.tv_name.setText(address.getName());
        holder.tv_phone.setText(address.getPhone());
        holder.tv_address.setText(address.getProvinceName()+
                address.getCityName()+
                address.getAreaName()+
                address.getAddress());
        return convertView;
    }

    public class ViewHolder {
        private TextView tv_name;
        private TextView tv_phone;
        private TextView tv_address;
    }


}
