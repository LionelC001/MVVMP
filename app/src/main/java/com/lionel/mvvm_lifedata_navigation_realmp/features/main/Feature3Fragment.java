package com.lionel.mvvm_lifedata_navigation_realmp.features.main;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lionel.mvvm_lifedata_navigation_realmp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Feature3Fragment extends Fragment {


    public Feature3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feature3, container, false);
    }

}
