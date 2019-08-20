package com.lionel.mvvm_lifedata_navigation_realmp.features.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.common.callback.IBottomBadgeSetter;

import java.util.Random;


public class Feature1Fragment extends Fragment {

    private IBottomBadgeSetter bottomBadgeSetter;

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
    }


    private void refreshBadge() {
        bottomBadgeSetter.refreshBadge((int) (Math.random() * 4), new Random().nextBoolean());
    }
}
