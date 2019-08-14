package com.lionel.mvvm_lifedata_navigation_realmp.features.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.lionel.mvvm_lifedata_navigation_realmp.R;


public class Feature1Fragment extends Fragment {

    public Feature1Fragment() {

    }

    public static Feature1Fragment newInstance() {
        Feature1Fragment fragment = new Feature1Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
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
}
