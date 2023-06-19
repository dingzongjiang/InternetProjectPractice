package com.example.internetprojectpractice.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.adapter.AcceptAddressAdapter;
import com.example.internetprojectpractice.pojo.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddressManageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddressManageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddressManageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddressManageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddressManageFragment newInstance(String param1, String param2) {
        AddressManageFragment fragment = new AddressManageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_address_manage, container, false);
        ListView lv_address = view.findViewById(R.id.lv_address);
        List<Address> addressList=getAddressList();
//        下面是测试代码，后面要删除
        for (int i = 0; i < 3; i++) {
            Address address = new Address();
            address.setName("张三");
            address.setPhone("12345678901");
            address.setProvince_name("广东省");
            address.setCity_name("广州市");
            address.setArea_name("天河区");
            address.setAddress("华南理工大学");
            addressList.add(address);
        }

        AcceptAddressAdapter adapter = new AcceptAddressAdapter(getActivity(), addressList);
        lv_address.setAdapter(adapter);

        return view;
    }

    private List<Address> getAddressList() {
        List<Address> addressList = new ArrayList<>();

        return addressList;
    }
}