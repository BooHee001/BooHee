package com.boohee.boohee.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.boohee.boohee.View.Message_Classifcamation;
import com.boohee.boohee.View.Seek_Activity;
import com.boohee.boohee.fragment.PartnerFragments.PartnerAdapter.Partner_Fragment_Adapter;
import com.boohee.boohee.fragment.PartnerFragments.Partnerfragmentes.PartnerFragment_fragment_friends;
import com.boohee.boohee.fragment.PartnerFragments.Partnerfragmentes.PartnerFragment_fragment_sift;
import com.boohee.boohee.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dizner on 2016/11/18.
 */

public class PartnerFragment extends Fragment {

    private RelativeLayout seek,message = null;
    private List<String> Partnerfragmenttitle;
    private List<Fragment> Partnerfragmentlist;
    private Partner_Fragment_Adapter adapter;
    private ViewPager partner_viewpager = null;
    private TabLayout partner_Tablayout = null;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.partner_fragment,container,false);

        initView(view);

        setData(view);


        partner_Tablayout.setupWithViewPager(partner_viewpager);
        partner_Tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        setTouch();

        return view;
    }

    private void setTouch() {
        seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Seek_Activity.class));
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Message_Classifcamation.class));
            }
        });

    }

    private void initView(View view) {
        partner_viewpager = (ViewPager) view.findViewById(R.id.partner_viewpager);
        partner_Tablayout = (TabLayout) view.findViewById(R.id.partner_Tablayout);
        seek = (RelativeLayout) view.findViewById(R.id.seek);
        message = (RelativeLayout) view.findViewById(R.id.message);

    }


    private void setData(View view) {




        Partnerfragmenttitle = new ArrayList<>();
        Partnerfragmentlist = new ArrayList<>();

        Partnerfragmenttitle.add("精选");
        Partnerfragmenttitle.add("好友圈");

        Partnerfragmentlist.add(PartnerFragment_fragment_sift.getInstance(1));
        Partnerfragmentlist.add(PartnerFragment_fragment_friends.getInstance(2));

        adapter = new Partner_Fragment_Adapter(getActivity().getSupportFragmentManager(),Partnerfragmentlist,Partnerfragmenttitle);
        partner_viewpager.setAdapter(adapter);

    }


}
