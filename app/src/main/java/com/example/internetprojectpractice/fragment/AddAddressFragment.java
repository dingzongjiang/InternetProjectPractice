package com.example.internetprojectpractice.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.internetprojectpractice.R;
import com.example.internetprojectpractice.dto.AddressDto;
import com.example.internetprojectpractice.pojo.Address;
import com.example.internetprojectpractice.pojo.CodeData;
import com.example.internetprojectpractice.pojo.FromData;
import com.example.internetprojectpractice.pojo.NameData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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
    private SharedPreferences sharedPreferences;
    private Gson gson;

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

        sharedPreferences = getActivity().getSharedPreferences("userInfo", getActivity().MODE_PRIVATE);
        gson = new Gson();

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
                System.out.println(aDdress);
                addAddress(aDdress);
            }
        }
    }

    private void addAddress(Address address) {
//        在这使用okhttp向服务器发送请求，添加地址
        OkHttpClient client = new OkHttpClient.Builder().build();
        CodeData codedata = new CodeData("", "", "");
        FromData fromdata = new FromData(address.getName(), address.getAddress(), address.getPhone());
        NameData namedata = new NameData(address.getProvinceName(), address.getCityName(), address.getAreaName());
        String token = sharedPreferences.getString("token", "");
        AddressDto addressDto = new AddressDto(codedata, fromdata, namedata, token);
        System.out.println(addressDto);
        String json = gson.toJson(addressDto);
        System.out.println(json);
        RequestBody requestBody = RequestBody.create(json,
                MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url("http://10.0.2.2:8080/address/add")
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try {
                    if (response.isSuccessful()) {
                        new AlertDialog.Builder(getActivity())
                                .setTitle("添加地址成功")
                                .setMessage("添加地址成功")
                                .setPositiveButton("确定", (dialog, which) -> {
                                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                                    ft.replace(R.id.fl_container_address,new AddressManageFragment());
                                    ft.commit();
                                })
                                .show();
                    }else {
                        new AlertDialog.Builder(getActivity())
                                .setTitle("添加地址失败")
                                .setMessage("添加地址失败")
                                .setPositiveButton("确定", null)
                                .show();
                    }
                } finally {
                    response.close();
                }
            }
        });

    }
}