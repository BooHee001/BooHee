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

public class PartmentFragment_fragment_friends extends Fragment{

    public PartmentFragment_fragment_friends(){}

    private int index;

    public static PartmentFragment_fragment_friends getInstance(int index){
        PartmentFragment_fragment_friends fragment_friends = new PartmentFragment_fragment_friends();

        Bundle bundle = new Bundle();
        bundle.putInt("index",index);
        fragment_friends.setArguments(bundle);

        return fragment_friends;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TextView txt = new TextView(getActivity());

        txt.setText("朋友圈"+getArguments().getInt("index"));


        return txt;
    }

}
