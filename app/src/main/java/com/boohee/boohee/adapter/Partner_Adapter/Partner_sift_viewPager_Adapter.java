package com.boohee.boohee.adapter.Partner_Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.Partner_sift;

import java.util.List;

/**
 * Created by Huochai on 2016/11/23.
 */

public class Partner_sift_viewPager_Adapter extends PagerAdapter{

    private Context context;
    //    private List<Partner_sift.ChannelBean> Partner_sift_pagerlist;
    private List<ImageView> partner_list;


    public Partner_sift_viewPager_Adapter(Context context, List<ImageView> partner_list) {
        this.context = context;
        this.partner_list = partner_list;
    }


    @Override
    public int getCount() {
        return partner_list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(partner_list.get(position));
        return partner_list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(partner_list.get(position));
    }
}
