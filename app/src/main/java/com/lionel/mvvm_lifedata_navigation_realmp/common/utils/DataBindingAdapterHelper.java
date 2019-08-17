package com.lionel.mvvm_lifedata_navigation_realmp.common.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class DataBindingAdapterHelper {

    @BindingAdapter({"setImageWithGlide"})
    public static void setImageWithGlide(ImageView view, String url) {
        Glide.with(view).load(url).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(view);
    }
}
