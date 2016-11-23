package com.boohee.boohee.fragment.PartnerFragments.Partnerfragmentes;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
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

    public PartnerFragment_fragment_sift(){ }

    private LinearLayout sift_loseweight,sift_succeed,sift_reduce,sift_hottopic = null;


    private ViewPager partner_sift_item_headVP = null;

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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.partner_sift_list,container,false);
        sift_loseweight = (LinearLayout) view.findViewById(R.id.sift_loseweight);
        sift_succeed = (LinearLayout) view.findViewById(R.id.sift_succeed);
        sift_reduce = (LinearLayout) view.findViewById(R.id.sift_reduce);
        sift_hottopic = (LinearLayout) view.findViewById(R.id.sift_hottopic);



        Partner_sift_list = (ListView) view.findViewById(R.id.Partner_sift_list);

        P_Partner_Impl p_partner_impl =new P_Partner_Impl(new V_Partner_sift() {
            @Override
            public void setPartnerBean(Partner_sift partner_sift) {

                View titleitem = inflater.inflate(R.layout.partner_sift_item_head,null);
                partner_sift_item_headVP = (ViewPager) titleitem.findViewById(R.id.partner_sift_item_headVP);




                Partner_sift_list.addHeaderView(titleitem);

                Partner_sift_ListView_Adapter siftAdapter = new Partner_sift_ListView_Adapter(partner_sift,getContext());
                Partner_sift_list.setAdapter(siftAdapter);
            }
        });

        p_partner_impl.initPartnerData();


        sift_loseweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        sift_succeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        sift_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        sift_hottopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return view;
    }
}
