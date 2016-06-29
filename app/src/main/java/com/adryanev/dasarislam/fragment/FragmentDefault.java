package com.adryanev.dasarislam.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adryanev.dasarislam.R;

/**
 * Created by AdryanEV on 29/06/2016.
 */
public class FragmentDefault extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_default,container,false);

        return view;
    }
}
