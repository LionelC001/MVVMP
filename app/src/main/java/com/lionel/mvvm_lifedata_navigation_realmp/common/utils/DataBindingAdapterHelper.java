package com.lionel.mvvm_lifedata_navigation_realmp.common.utils;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.lionel.mvvm_lifedata_navigation_realmp.common.utils.Constant.YYYY_MM_DD_HH_MM_SS;
import static com.lionel.mvvm_lifedata_navigation_realmp.common.utils.Constant.YYYY_MM_DD_T_HH_MM_SS_Z;

public class DataBindingAdapterHelper {

    @BindingAdapter({"setImageWithGlide"})
    public static void setImageWithGlide(ImageView view, String url) {
        Glide.with(view).load(url).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(view);
    }

    @BindingAdapter({"setFormattedDate"})
    public static void setFormattedDate(TextView view, String strDate) {
        try {
            SimpleDateFormat sdfOrigin = new SimpleDateFormat(YYYY_MM_DD_T_HH_MM_SS_Z, Locale.TAIWAN);
            Date date = sdfOrigin.parse(strDate);
            SimpleDateFormat sdfFormatted = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS, Locale.TAIWAN);
            String strFormatted = sdfFormatted.format(date);
            view.setText(strFormatted);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
