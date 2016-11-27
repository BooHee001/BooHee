package com.boohee.boohee.adapter.Partner_Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.boohee.boohee.View.MainActivity;
import com.boohee.boohee.View.Partner_View.Sift_item_ViewPager_WebView1;
import com.boohee.boohee.View.Partner_View.Sift_reduce_WebView_Activity;

import java.util.List;

/**
 * Created by Huochai on 2016/11/25.
 */

public class Partner_sift_ViewPager_Adapter2 extends PagerAdapter {

    private List<ImageView> imageviewlist = null;
    private Context Vp1context;
    private LayoutInflater bsman = null;

    public Partner_sift_ViewPager_Adapter2(Context vp1context,List<ImageView> imageviewlist) {
        this.Vp1context = vp1context;
        this.imageviewlist = imageviewlist;

        bsman = LayoutInflater.from(vp1context);
    }

    @Override
    public int getCount() {
        return imageviewlist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageviewlist.get(position));
        imageviewlist.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent vp1intent = new Intent(Vp1context, Sift_item_ViewPager_WebView1.class);
                Vp1context.startActivity(vp1intent);


            }
        });
        imageviewlist.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vp1intent = new Intent(Vp1context, Sift_reduce_WebView_Activity.class);
                Vp1context.startActivity(vp1intent);
            }
        });

        return imageviewlist.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageviewlist.get(position));
    }
}
