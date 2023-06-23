package com.example.internetprojectpractice.fragment;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
    private ListView lv_address;
    private OkHttpClient client;
    private Gson gson;
    private SharedPreferences sharedPreferences;

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

        client = new OkHttpClient.Builder().build();
        gson = new Gson();

        sharedPreferences = getActivity().getSharedPreferences("userInfo", getActivity().MODE_PRIVATE);

        lv_address = view.findViewById(R.id.lv_address);

        getAddressList();

        return view;
    }

    private void getAddressList() {
        Request request = new Request.Builder()
                .addHeader("token",sharedPreferences.getString("token",""))
                .get()
                .url("http://10.0.2.2:8080/address")
                .build();
//        Log.i(TAG, "我到这里了，我是AddressManageFragment，request ="+request);
        System.out.println("我到这里了，我是AddressManageFragment，request ="+request);
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
                        String json = response.body().string();
                        System.out.println("我到这里了，我是AddressManageFragment，json ="+json);
                        Type type = new TypeToken<List<Address>>() {
                        }.getType();
                        List<Address> addressList = gson.fromJson(json, type);
//                        Log.i(TAG, "我到这里了，我是AddressManageFragment，addressList ="+addressList);
                        System.out.println("我到这里了，我是AddressManageFragment，addressList ="+addressList);
                        render(addressList);
                    }
                } finally {
                    response.close();
                }
            }
        });

    }

    private void render(List<Address> addressList) {
        AcceptAddressAdapter adapter = new AcceptAddressAdapter(getActivity(), addressList);
        lv_address.setAdapter(adapter);
    }
}