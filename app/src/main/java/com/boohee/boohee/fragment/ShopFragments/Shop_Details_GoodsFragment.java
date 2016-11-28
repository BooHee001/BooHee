package com.boohee.boohee.fragment.ShopFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.boohee.boohee.Bean.shop_Bean.Shop_GoodsInfo_Bean;
import com.boohee.boohee.R;
import com.boohee.boohee.View.Shop_View.V_Shop_GoodsInfo;
import com.boohee.boohee.adapter.Shop_Adapter.Shop_GoodsInfo_ViewPager_Adapter;
import com.boohee.boohee.presenter.Shop_Presenter.P_Shop_GoodsInfo_Impl;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by as on 2016/11/21.
 */

public class Shop_Details_GoodsFragment extends Fragment{
    @BindView(R.id.Shop_GoodsInfo_Lift)
    ViewPager shop_GoodsInfo_Lift;
    @BindView(R.id.Shop_GoodsInfo_Title)
    TextView shop_GoodsInfo_Title;
    @BindView(R.id.Shop_GoodsInfo_MinPic)
    TextView shop_GoodsInfo_MinPic;
    @BindView(R.id.Shop_GoodsInfo_Text)
    TextView shop_GoodsInfo_Text;
    @BindView(R.id.GoodInfo)
    CirclePageIndicator GoodInfo;
    @BindView(R.id.GoodsInfo_Loading)
    ProgressBar GoodsInfo_Loading;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.shop_goodsinfo_lift, null);
        ButterKnife.bind(this,inflate);
        GoodsInfo_Loading.setVisibility(View.VISIBLE);
        Bundle bundle = getArguments();
        int id = bundle.getInt("id");
        P_Shop_GoodsInfo_Impl p_shop_goodsInfo = new P_Shop_GoodsInfo_Impl(new V_Shop_GoodsInfo() {
            @Override
            public void setData(Shop_GoodsInfo_Bean shop_goodsInfo_bean) {
                shop_GoodsInfo_Title.setText(shop_goodsInfo_bean.getGoods().getTitle());
                shop_GoodsInfo_MinPic.setText("¥"+" "+shop_goodsInfo_bean.getGoods().getMarket_price()+"");
                shop_GoodsInfo_Text.setText(shop_goodsInfo_bean.getGoods().getDescription());
                List<String> square_photo_urls = shop_goodsInfo_bean.getGoods().getSquare_photo_urls();
                shop_GoodsInfo_Lift.setAdapter(new Shop_GoodsInfo_ViewPager_Adapter(square_photo_urls,getContext()));
                GoodInfo.setViewPager(shop_GoodsInfo_Lift);
                GoodsInfo_Loading.setVisibility(View.GONE);
            }
        });
        p_shop_goodsInfo.initData(id);
        return inflate;
    }
}
