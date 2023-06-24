package com.example.internetprojectpractice.decoration;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by lenovo on 2023/06/18
 * 用于设置RecyclerView的Item间距
 * 用法：RecyclerView.addItemDecoration(new SpacingItemDecoration(10));
 */
public class SpacingItemDecoration extends RecyclerView.ItemDecoration{
    private int spacing;

    public SpacingItemDecoration(int spacing) {
        this.spacing = spacing;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.top = spacing;
        outRect.bottom = spacing;
    }
}
