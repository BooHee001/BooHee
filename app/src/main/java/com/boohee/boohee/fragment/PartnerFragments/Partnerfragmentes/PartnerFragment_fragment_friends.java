package com.boohee.boohee.fragment.PartnerFragments.Partnerfragmentes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.Partner_friends;
import com.boohee.boohee.R;
import com.boohee.boohee.View.Partner_View.V_Partner_friends;
import com.boohee.boohee.adapter.Partner_Adapter.Partner_friends_ListView_Adapter;
import com.boohee.boohee.presenter.Partner_Presenter.P_friends_Partner;
import com.boohee.boohee.presenter.Partner_Presenter.P_friends_Partner_Impl;

/**
 * Created by PF on 2016/11/18.
 */

public class PartnerFragment_fragment_friends extends Fragment{

    public PartnerFragment_fragment_friends(){}

    private ListView Partner_friends_list = null;
    private ProgressBar friends_Fragment_Loading = null;


    public static PartnerFragment_fragment_friends getInstance(int index){
        PartnerFragment_fragment_friends fragment_friends = new PartnerFragment_fragment_friends();

        Bundle bundle = new Bundle();
        bundle.putInt("index",index);
        fragment_friends.setArguments(bundle);

        return fragment_friends;
    }


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.partner_friends_list,container,false);


        Partner_friends_list = (ListView) view.findViewById(R.id.Partner_friends_list);
        friends_Fragment_Loading = (ProgressBar) view.findViewById(R.id.friends_Fragment_Loading);



        P_friends_Partner_Impl p_friends_partner_impl = new P_friends_Partner_Impl(new V_Partner_friends() {
            @Override
            public void setFriendsPartnerBean(Partner_friends partner_friends) {

                friends_Fragment_Loading.setVisibility(View.VISIBLE);
                View titleitem = inflater.inflate(R.layout.partner_friends_item_head,null);

                Partner_friends_list.addHeaderView(titleitem);

                Partner_friends_ListView_Adapter friendsadapter = new Partner_friends_ListView_Adapter(partner_friends ,getContext());
                Partner_friends_list.setAdapter(friendsadapter);
                friends_Fragment_Loading.setVisibility(View.GONE);
            }
        });
        p_friends_partner_impl.initFriendsPartner();


        return view;
    }



}
