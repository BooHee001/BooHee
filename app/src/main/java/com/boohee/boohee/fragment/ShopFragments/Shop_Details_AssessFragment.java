package com.boohee.boohee.fragment.ShopFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boohee.boohee.R;

/**
 * Created by as on 2016/11/21.
 */

public class Shop_Details_AssessFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View v =LayoutInflater.from(getContext()).inflate(R.layout.activity_pinglun,null);
        return v;
    }
}
