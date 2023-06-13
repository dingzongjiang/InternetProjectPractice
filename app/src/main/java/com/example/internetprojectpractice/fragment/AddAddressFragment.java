package com.example.internetprojectpractice.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.pojo.Address;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddAddressFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddAddressFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText et_name;
    private EditText et_address;
    private EditText et_phone;
    private EditText et_address_province;
    private EditText et_address_city;
    private EditText et_address_area;

    public AddAddressFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddAddressFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddAddressFragment newInstance(String param1, String param2) {
        AddAddressFragment fragment = new AddAddressFragment();
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
        View view = inflater.inflate(R.layout.fragment_add_address, container, false);

        et_name = view.findViewById(R.id.et_name);
        et_address = view.findViewById(R.id.et_address);
        et_phone = view.findViewById(R.id.et_phone);
        et_address_province = view.findViewById(R.id.et_address_province);
        et_address_city = view.findViewById(R.id.et_address_city);
        et_address_area = view.findViewById(R.id.et_address_area);


        view.findViewById(R.id.btn_add_address).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add_address) {
            String address = et_address.getText().toString();
            String name = et_name.getText().toString();
            String phone = et_phone.getText().toString();
            String province = et_address_province.getText().toString();
            String city = et_address_city.getText().toString();
            String area = et_address_area.getText().toString();
            if (address.equals("") || name.equals("")
                    || phone.equals("") || province.equals("")
                    || city.equals("") || area.equals("")) {
                Toast.makeText(getActivity(), "你的信息不完备，请继续完善你的信息", Toast.LENGTH_SHORT).show();
            } else {
                Address aDdress = new Address(name, province, city, area, address, phone);
                addAddress(aDdress);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.show(new AddressManageFragment()).hide(this).commit();
            }
        }
    }

    private void addAddress(Address address) {
//        在这使用okhttp向服务器发送请求，添加地址
        Toast.makeText(getActivity(), "添加地址成功", Toast.LENGTH_SHORT).show();
    }
}