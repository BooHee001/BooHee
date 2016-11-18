package com.boohee.boohee.PartnerFragments.Partnerfragmentes;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by PF on 2016/11/18.
 */

public class PartnerFragment_fragment_sift extends Fragment{

    public PartnerFragment_fragment_sift(){}

    private int index;

    public static PartnerFragment_fragment_sift getInstance(int index){
        PartnerFragment_fragment_sift fragment_sift = new PartnerFragment_fragment_sift();

        Bundle bundle = new Bundle();
        bundle.putInt("index",index);
        fragment_sift.setArguments(bundle);

        return fragment_sift;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TextView txt = new TextView(getActivity());

        txt.setText("精选"+getArguments().getInt("index"));


        return txt;
    }
}
