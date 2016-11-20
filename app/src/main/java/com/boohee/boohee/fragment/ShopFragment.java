package com.boohee.boohee.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.boohee.boohee.Bean.Shop_Bean.Shop_Goods;
import com.boohee.boohee.R;
import com.boohee.boohee.Utils.Shop_Utils.BadgeView;
import com.boohee.boohee.View.Shop_View.V_Shop;
import com.boohee.boohee.adapter.Shop_Adapter.Shop_Goods_Adapter;
import com.boohee.boohee.presenter.Shop_Presenter.P_Shop_Impl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dizner on 2016/11/18.
 */

public class ShopFragment extends Fragment {
    View view;
    @BindView(R.id.Shop_Search)
    RelativeLayout shop_Search;
    @BindView(R.id.Shop_Message)
    RelativeLayout shop_Message;
    @BindView(R.id.Shop_Badge)
    BadgeView shop_Badge;
    @BindView(R.id.Shop_ListView)
    ListView shop_ListView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view ==null) {
            view = inflater.inflate(R.layout.shop_fragment, container, false);
            ButterKnife.bind(this,view);
            //给listviewS设置头部
            View headerView = getActivity().getLayoutInflater().inflate(R.layout.shop_listview_header, null);
            shop_ListView.addHeaderView(headerView);
            setData();
        }
        return view;
    }

    private void setData() {
        P_Shop_Impl p_Shop = new P_Shop_Impl(new V_Shop() {
            @Override
            public void setShopData(Shop_Goods shop_goods) {
                shop_ListView.setAdapter(new Shop_Goods_Adapter(shop_goods,getContext()));
            }
        });
        p_Shop.initData();
    }
}
