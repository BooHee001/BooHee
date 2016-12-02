package com.boohee.boohee.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.boohee.boohee.Bean.shop_Bean.Shop_Goods;
import com.boohee.boohee.R;
import com.boohee.boohee.Utils.Shop_Utils.BadgeView;
import com.boohee.boohee.View.Message_Classifcamation;
import com.boohee.boohee.View.Message_classification_Activity;
import com.boohee.boohee.View.Seek_Activity;
import com.boohee.boohee.View.Shop_View.DingDan_Activity;
import com.boohee.boohee.View.Shop_View.GoodsCar_Activity;
import com.boohee.boohee.View.Shop_View.V_Shop;
import com.boohee.boohee.adapter.Shop_Adapter.Shop_Goods_Adapter;
import com.boohee.boohee.presenter.Shop_Presenter.P_Shop_Impl;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dizner on 2016/11/18.
 */

public class ShopFragment extends Fragment {
    @BindView(R.id.Shop_Fragment_Loading)
    ProgressBar Shop_Fragment_Loading;
    View view;
    @BindView(R.id.Shop_Search)
    RelativeLayout shop_Search;
    @BindView(R.id.Shop_Message)
    RelativeLayout shop_Message;
    @BindView(R.id.Shop_Badge)
    BadgeView shop_Badge;
    @BindView(R.id.Shop_ListView)
    PullToRefreshListView shop_ListView;

    Intent intent =null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view ==null) {
            view = inflater.inflate(R.layout.shop_fragment, container, false);
            ButterKnife.bind(this,view);
            intent = new Intent();
            Shop_Fragment_Loading.setVisibility(View.VISIBLE);
            ListView listView =shop_ListView.getRefreshableView();
            //给listviewS设置头部
            View headerView = getActivity().getLayoutInflater().inflate(R.layout.shop_listview_header, null);
            //购物车的条目点击事件
            headerView.findViewById(R.id.ShoppingCar).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), GoodsCar_Activity.class);
                    getContext().startActivity(intent);
                }
            });
            //订单的条目点击事件
            headerView.findViewById(R.id.DingDan).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),DingDan_Activity.class);
                    getContext().startActivity(intent);
                }
            });
            listView.addHeaderView(headerView);
            setData();
            setListener();
        }
        return view;
    }

    private void setListener() {
       shop_ListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
           @Override
           public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
               setData();

           }

           @Override
           public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
           }
       });
    }

    @OnClick(R.id.Shop_Search)
    public  void Shop_Search(View v){
        intent.setClass(getActivity(), Seek_Activity.class);
        getContext().startActivity(intent);
    }
    @OnClick(R.id.Shop_Message)
    public  void Shop_Message(View v){
        intent.setClass(getActivity(), Message_Classifcamation   .class);
        getContext().startActivity(intent);
//        Toast.makeText(getActivity(), "aaaaa", Toast.LENGTH_SHORT).show();

    }
    private void setData() {
        P_Shop_Impl p_Shop = new P_Shop_Impl(new V_Shop() {
            @Override
            public void setShopData(Shop_Goods shop_goods) {
                shop_ListView.setAdapter(new Shop_Goods_Adapter(shop_goods,getContext()));
                Shop_Fragment_Loading.setVisibility(View.GONE);
                shop_ListView.onRefreshComplete();
            }
        });
        p_Shop.initData();

    }
}
