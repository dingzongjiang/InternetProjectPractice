package com.example.internetprojectpractice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.internetprojectpractice.databinding.ActivityMainBinding;
import com.example.internetprojectpractice.fragment.CartFragment;
import com.example.internetprojectpractice.fragment.CategoryFragment;
import com.example.internetprojectpractice.fragment.HomeFragment;
import com.example.internetprojectpractice.fragment.UserFragment;

public class MainActivity2 extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup rg_button;
    //    tab对应的fragment
    private Fragment homeFragment;
    private Fragment categoryFragment;
    private Fragment cartFragment;
    private Fragment userFragment;
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
        homeFragment = new HomeFragment();
        categoryFragment = new CategoryFragment();
        cartFragment = new CartFragment();
        userFragment = new UserFragment();
        ft.add(R.id.container, homeFragment, "home");
        ft.add(R.id.container, categoryFragment, "category");
        ft.add(R.id.container, cartFragment, "cart");
        ft.add(R.id.container, userFragment, "user");
        ft.show(homeFragment).hide(categoryFragment).hide(cartFragment).hide(userFragment);
        ft.commit();
    }

    private void bindEvent() {
        rb_home = findViewById(R.id.rb_home);
        rg_button.setOnCheckedChangeListener(this);
        rb_home.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (checkedId == R.id.rb_home) {
            ft.show(homeFragment).hide(categoryFragment).hide(cartFragment).hide(userFragment).commit();
        }
        if (checkedId == R.id.rb_category) {
            ft.show(categoryFragment).hide(homeFragment).hide(cartFragment).hide(userFragment).commit();
        }
        if (checkedId == R.id.rb_cart) {
            ft.show(cartFragment).hide(categoryFragment).hide(homeFragment).hide(userFragment).commit();
        }
        if (checkedId == R.id.rb_user) {
            ft.show(userFragment).hide(categoryFragment).hide(cartFragment).hide(homeFragment).commit();
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        for (int i = 0; i < rg_button.getChildCount(); i++) {
            RadioButton mTab = (RadioButton) rg_button.getChildAt(i);
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentByTag((String) mTab.getTag());
            FragmentTransaction ft = fm.beginTransaction();
            if (fragment != null) {
                if (fragment.isAdded()) {
                    ft.hide(fragment);
                }
            }
            ft.commit();
        }
    }
}