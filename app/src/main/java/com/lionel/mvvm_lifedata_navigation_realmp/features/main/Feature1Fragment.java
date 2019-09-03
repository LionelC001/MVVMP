package com.lionel.mvvm_lifedata_navigation_realmp.features.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.common.callback.IBottomBadgeSetter;
import com.lionel.mvvm_lifedata_navigation_realmp.common.callback.IThemeSetter;

import java.util.Random;

import static com.lionel.mvvm_lifedata_navigation_realmp.common.utils.Constant.TYPE_THEME_DARK;
import static com.lionel.mvvm_lifedata_navigation_realmp.common.utils.Constant.TYPE_THEME_LIGHT;


public class Feature1Fragment extends Fragment {

    private IBottomBadgeSetter bottomBadgeSetter;
    private IThemeSetter themeSetter;

    public Feature1Fragment() {

    }

    public static Feature1Fragment newInstance() {
        Feature1Fragment fragment = new Feature1Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof IBottomBadgeSetter) {
            bottomBadgeSetter = (IBottomBadgeSetter) context;
        }

        if (context instanceof IThemeSetter) {
            themeSetter = (IThemeSetter) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feature1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
    }

    private void initView() {
        Button btnBadge = getView().findViewById(R.id.btnBadge);
        btnBadge.setOnClickListener(v -> refreshBadge());

        Button btnTheme = getView().findViewById(R.id.btnTheme);
        btnTheme.setOnClickListener(v -> changeTheme());
    }


    private void refreshBadge() {
        bottomBadgeSetter.refreshBadge((int) (Math.random() * 4), new Random().nextBoolean());
    }

    private void changeTheme() {
        if (themeSetter != null)
            if (MainActivity.typeTheme == TYPE_THEME_LIGHT ) {  //should use sharedPreferences instead
                themeSetter.onThemeChanged(TYPE_THEME_DARK);
        } else {
            themeSetter.onThemeChanged(TYPE_THEME_LIGHT);
        }
    }
}
