package com.lionel.mvvm_lifedata_navigation_realmp.features.feature3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.lionel.mvvm_lifedata_navigation_realmp.R;

import java.util.List;

public class Featue3_1ViewAdapter extends PagerAdapter {

    private final Context context;
    private final List<Integer> listSrcView;

    public Featue3_1ViewAdapter(Context context, List<Integer> data) {
        this.context = context;
        this.listSrcView = data;
    }

    @Override
    public int getCount() {
        return listSrcView != null ? listSrcView.size() : 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_feature3_1, container, false);
        ImageView imgView = view.findViewById(R.id.imgView);
        Glide.with(context).load(listSrcView.get(position)).into(imgView);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
