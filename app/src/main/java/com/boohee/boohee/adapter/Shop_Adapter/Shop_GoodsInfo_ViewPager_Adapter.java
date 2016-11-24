package com.boohee.boohee.adapter.Shop_Adapter;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by as on 2016/11/23.
 */

public class Shop_GoodsInfo_ViewPager_Adapter extends PagerAdapter {
    private List<String> square_photo_urls;
    private Context context;

    public Shop_GoodsInfo_ViewPager_Adapter(List<String> square_photo_urls, Context context) {
        this.square_photo_urls = square_photo_urls;
        this.context = context;
    }

    @Override
    public int getCount() {
        return square_photo_urls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv = new ImageView(context);
        Glide.with(context).load(square_photo_urls.get(position)).into(iv);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
