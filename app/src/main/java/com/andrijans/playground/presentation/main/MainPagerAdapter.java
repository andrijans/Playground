package com.andrijans.playground.presentation.main;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MainPagerAdapter extends PagerAdapter {
    private View[] childViews;

    public MainPagerAdapter(View[] childViews) {
        this.childViews = childViews;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(childViews[position]);
        return childViews[position];
    }


    @Override
    public int getCount() {
        return childViews.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}