package com.boohee.boohee.fragment.PartnerFragments.Partnerfragmentes;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.Partner_sift;
import com.boohee.boohee.R;
import com.boohee.boohee.View.Partner_View.V_Partner_sift;
import com.boohee.boohee.adapter.Partner_Adapter.Partner_sift_ListView_Adapter;
import com.boohee.boohee.presenter.Partner_Presenter.P_Partner_Impl;

/**
 * Created by PF on 2016/11/18.
 */

public class PartnerFragment_fragment_sift extends Fragment{

    public PartnerFragment_fragment_sift(){}


    private int index;


    private ListView Partner_sift_list = null;

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



        View view = inflater.inflate(R.layout.partner_sift_list,container,false);

        Partner_sift_list = (ListView) view.findViewById(R.id.Partner_sift_list);

        P_Partner_Impl p_partner_impl =new P_Partner_Impl(new V_Partner_sift() {
            @Override
            public void setPartnerBean(Partner_sift partner_sift) {
                Partner_sift_ListView_Adapter siftAdapter = new Partner_sift_ListView_Adapter(partner_sift,getContext());
                Partner_sift_list.setAdapter(siftAdapter);
            }
        });

        p_partner_impl.initPartnerData();


        return view;
    }
}
