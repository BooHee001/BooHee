package com.boohee.boohee.adapter.Shop_Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by as on 2016/11/21.
 */

public class Shop_Details_ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment>  fragmentList;
    public Shop_Details_ViewPagerAdapter(FragmentManager fm,List<Fragment>  fragmentList) {
        super(fm);
        this.fragmentList =fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
