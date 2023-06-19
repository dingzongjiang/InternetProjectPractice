package com.example.internetprojectpractice.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.internetprojectpractice.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdateAddressFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateAddressFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText et_name_update;
    private EditText et_province_update;
    private EditText et_city_update;
    private EditText et_area_update;
    private EditText et_address_update;
    private EditText et_phone_update;
    private Button btn_update_address;
    private String name;
    private String province;
    private String city;
    private String area;
    private String address;
    private String phone;

    public UpdateAddressFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateAddressFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateAddressFragment newInstance(String param1, String param2) {
        UpdateAddressFragment fragment = new UpdateAddressFragment();
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
        View view = inflater.inflate(R.layout.fragment_update_address, container, false);
        Bundle bundle = getArguments();
//        int addressId = bundle.getInt("id");
        et_name_update = view.findViewById(R.id.et_name_update);
        et_province_update = view.findViewById(R.id.et_address_province_update);
        et_city_update = view.findViewById(R.id.et_address_city_update);
        et_area_update = view.findViewById(R.id.et_address_area_update);
        et_address_update = view.findViewById(R.id.et_address_update);
        et_phone_update = view.findViewById(R.id.et_phone_update);
        btn_update_address = view.findViewById(R.id.btn_update_address);
        btn_update_address.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_update_address) {
            boolean flag = checkMessageIsEntire();
            if (flag) {
                Toast.makeText(getContext(), "修改成功", Toast.LENGTH_SHORT).show();
                updateAddress();
            }else {
                Toast.makeText(getContext(), "请填写完整信息", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void updateAddress() {
    }

    private boolean checkMessageIsEntire() {
        name = et_name_update.getText().toString();
        province = et_province_update.getText().toString();
        city = et_city_update.getText().toString();
        area = et_area_update.getText().toString();
        address = et_address_update.getText().toString();
        phone = et_phone_update.getText().toString();
        if (name.equals("") || province.equals("") || city.equals("")
                || area.equals("") || address.equals("") || phone.equals("")) {
            return false;
        } else {
            return true;
        }
    }
}