package com.boohee.boohee.adapter.Partner_Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.boohee.boohee.Bean.shop_Bean.partner_Bean.Partner_ViewPager;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Huochai on 2016/11/23.
 */

public class Partner_sift_viewPager_Adapter extends PagerAdapter{

    private Context context;
    private List< Partner_ViewPager.SlidersBean> SlidersBean;


    public Partner_sift_viewPager_Adapter(Context context, List< Partner_ViewPager.SlidersBean> SlidersBean) {
        this.context = context;
        this.SlidersBean = SlidersBean;
    }


    @Override
    public int getCount() {
        return SlidersBean.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView vpiv = new ImageView(context);
        Glide.with(context).load(SlidersBean.get(position)).into(vpiv);
        vpiv.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(vpiv);

        

        return vpiv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
