package com.boohee.boohee.adapter.Partner_Adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.boohee.boohee.R;

import org.xutils.image.ImageOptions;

import java.util.List;


/**
 * Created by Dizner on 2016/11/12.
 */

public class PhotoPagerAdapter extends PagerAdapter {
    private List<View> list;
    private Activity activity;
    private ImageOptions options;

    public PhotoPagerAdapter(List<View> list, Activity activity) {
        this.list = list;
        this.activity = activity;
        options=new ImageOptions.Builder()
                .setLoadingDrawableId(R.drawable.default_place)
                .build();
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        container.addView(list.get(position));
        return list.get(position);

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));

    }
}
