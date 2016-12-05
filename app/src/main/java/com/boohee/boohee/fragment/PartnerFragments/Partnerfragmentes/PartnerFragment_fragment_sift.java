package com.boohee.boohee.fragment.PartnerFragments.Partnerfragmentes;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.boohee.boohee.Bean.shop_Bean.partner_Bean.Partner_sift;

import com.boohee.boohee.R;
import com.boohee.boohee.View.Partner_View.Sift_WebView_hot_Activity;
import com.boohee.boohee.View.Partner_View.Sift_loseweight_WebView_Activity;
import com.boohee.boohee.View.Partner_View.Sift_reduce_WebView_Activity;
import com.boohee.boohee.View.Partner_View.Sift_succeed_WebView_Activity;
import com.boohee.boohee.View.Partner_View.V_Partner_sift;
import com.boohee.boohee.adapter.Partner_Adapter.Partner_sift_ListView_Adapter;
import com.boohee.boohee.adapter.Partner_Adapter.Partner_sift_ViewPager_Adapter2;
import com.boohee.boohee.presenter.Partner_Presenter.P_sift_Partner_Impl;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PF on 2016/11/18.
 */

public class PartnerFragment_fragment_sift extends Fragment{

    public PartnerFragment_fragment_sift(){ }

    private LinearLayout sift_loseweight,sift_succeed,sift_reduce,sift_hottopic = null;
    private View.OnClickListener sift_loseweight_listener = null;


    private ProgressBar sift_Fragment_Loading = null;

    private ViewPager partner_sift_item_headVP = null;
    private List<ImageView> imageviewlist = null;
    private int[] imgs = new int[] {R.mipmap.banner,R.mipmap.cosp};

    private CirclePageIndicator siftInfo = null;

    private PullToRefreshListView Partner_sift_list = null;

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

        View titleitem = inflater.inflate(R.layout.partner_sift_item_head,null);

        initView(view,titleitem);

        ListView siftlistview = Partner_sift_list.getRefreshableView();
        //头条目viewpager
        setImageViewlist(titleitem);

        siftlistview.addHeaderView(titleitem);
        //主listview
        setListViewData();
        //刷新事件
        setListener();

        setOnclicks();

        return view;
    }

    public void initView(View view,View titleitem){

        Partner_sift_list = (PullToRefreshListView) view.findViewById(R.id.Partner_sift_list);
        sift_Fragment_Loading = (ProgressBar) view.findViewById(R.id.sift_Fragment_Loading);

        partner_sift_item_headVP = (ViewPager) titleitem.findViewById(R.id.partner_sift_item_headVP);
        sift_loseweight = (LinearLayout) titleitem.findViewById(R.id.sift_loseweight);
        sift_succeed = (LinearLayout) titleitem.findViewById(R.id.sift_succeed);
        sift_reduce = (LinearLayout) titleitem.findViewById(R.id.sift_reduce);
        sift_hottopic = (LinearLayout) titleitem.findViewById(R.id.sift_hottopic);
        siftInfo = (CirclePageIndicator) titleitem.findViewById(R.id.siftInfo);

    }


    public void setImageViewlist(View titleitem){

//        setImageViewlist(view,titleitem);
        imageviewlist = new ArrayList<ImageView>();
        for (int i = 0; i < imgs.length; i++) {
            ImageView iv = new ImageView(getContext());

            iv.setImageResource(imgs[i]);
            imageviewlist.add(iv);

        }
        Partner_sift_ViewPager_Adapter2 pageradapter2 = new Partner_sift_ViewPager_Adapter2(getContext(),imageviewlist);
        partner_sift_item_headVP.setOffscreenPageLimit(2);
        partner_sift_item_headVP.setAdapter(pageradapter2);
        siftInfo.setViewPager(partner_sift_item_headVP);




    }

    public void setListViewData(){

        P_sift_Partner_Impl p_sift_partner_impl =new P_sift_Partner_Impl(new V_Partner_sift() {
            @Override
            public void setPartnerBean(Partner_sift partner_sift) {

                sift_Fragment_Loading.setVisibility(View.VISIBLE);

                Partner_sift_ListView_Adapter siftAdapter = new Partner_sift_ListView_Adapter(partner_sift,getContext());
                Partner_sift_list.setAdapter(siftAdapter);



                sift_Fragment_Loading.setVisibility(View.GONE);

                Partner_sift_list.onRefreshComplete();
            }
        });

        p_sift_partner_impl.initPartnerData();
    }

    public void setOnclicks(){

        sift_loseweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Sift_loseweight_WebView_Activity.class));
            }
        });
        sift_succeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getActivity(), Sift_succeed_WebView_Activity.class));
            }
        });
        sift_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Sift_reduce_WebView_Activity.class));
            }
        });
        sift_hottopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Sift_WebView_hot_Activity.class));
            }
        });

    }

    private void setListener() {
        Partner_sift_list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                setListViewData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

                Toast.makeText(getActivity(), "哎呀，木有更多了~", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
