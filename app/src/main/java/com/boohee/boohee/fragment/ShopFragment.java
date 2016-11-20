package com.boohee.boohee.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boohee.boohee.R;

/**
 * Created by Dizner on 2016/11/18.
 */

public class ShopFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       if(view ==null) {
           view = inflater.inflate(R.layout.shop_fragment, container, false);
       }
        return view;
    }
}
