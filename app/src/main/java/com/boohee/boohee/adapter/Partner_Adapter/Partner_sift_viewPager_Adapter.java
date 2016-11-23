package com.boohee.boohee.adapter.Partner_Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.Partner_sift;

import java.util.List;

/**
 * Created by Huochai on 2016/11/23.
 */

public class Partner_sift_viewPager_Adapter extends PagerAdapter{

    private Context context;
    private List<Partner_sift.ChannelBean> Partner_sift_pagerlist;


    @Override
    public int getCount() {
        return Partner_sift_pagerlist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
