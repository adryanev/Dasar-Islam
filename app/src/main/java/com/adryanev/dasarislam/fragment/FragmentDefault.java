package com.adryanev.dasarislam.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.adryanev.dasarislam.R;

/**
 * Created by AdryanEV on 29/06/2016.
 */
public class FragmentDefault extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_default,container,false);

        return view;
    }
}
