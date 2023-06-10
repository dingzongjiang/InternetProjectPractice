package com.example.internetprojectpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.internetprojectpractice.fragment.HomeFragment;

public class MainActivity2 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg_button;
//    tab对应的fragment
    private Fragment HomeFragment;
    private Fragment CategoryFragment;
    private Fragment CartFragment;
    private Fragment UserFragment;

    private RadioButton mRadioButtonHome;
    private RadioButton rb_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rg_button = findViewById(R.id.radio_group_button);
        initFragment();
        bindEvent();
    }

    private void initFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        HomeFragment = new HomeFragment();
        CategoryFragment = new HomeFragment();
        CartFragment = new HomeFragment();
        UserFragment = new HomeFragment();
        ft.add(R.id.container, HomeFragment,"home");
        ft.add(R.id.container, CategoryFragment,"category");
        ft.add(R.id.container, CartFragment,"cart");
        ft.add(R.id.container, UserFragment,"user");
        ft.show(HomeFragment).hide(CategoryFragment).hide(CartFragment).hide(UserFragment);
        ft.commit();
    }

    private void bindEvent(){
        rb_home = findViewById(R.id.rb_home);
        rg_button.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (checkedId == R.id.rb_home){
            ft.show(HomeFragment).hide(CategoryFragment).hide(CartFragment).hide(UserFragment);
        }
        if (checkedId == R.id.rb_category){
            ft.show(CategoryFragment).hide(HomeFragment).hide(CartFragment).hide(UserFragment);
        }
        if (checkedId == R.id.rb_cart){
            ft.show(CartFragment).hide(CategoryFragment).hide(HomeFragment).hide(UserFragment);
        }
        if (checkedId == R.id.rb_user){
            ft.show(UserFragment).hide(CategoryFragment).hide(CartFragment).hide(HomeFragment);
        }
        rb_home.setChecked(true);
        ft.commit();
    }
}