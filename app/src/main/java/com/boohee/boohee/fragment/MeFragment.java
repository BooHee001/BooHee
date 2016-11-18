package com.boohee.boohee.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Dizner on 2016/11/18.
 */

public class MeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView view=new TextView(getContext());
        view.setText("我的信息");
        view.setTextColor(Color.YELLOW);
        view.setTextSize(20);
        return view;
    }
}
