package com.boohee.boohee.fragment.PartnerFragments.PartnerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by PF on 2016/11/18.
 */

public class Partner_Fragment_Adapter extends FragmentPagerAdapter{

    private List<String> Partnerfragmenttitle;
    private List<Fragment> Partnerfragmentlist;


    public Partner_Fragment_Adapter(FragmentManager fm, List<Fragment> partnerfragmentlist, List<String> partnerfragmenttitle) {
        super(fm);
        this.Partnerfragmenttitle = partnerfragmenttitle;
        this.Partnerfragmentlist = partnerfragmentlist;

    }

    @Override
    public Fragment getItem(int position) {
        return Partnerfragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return Partnerfragmentlist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Partnerfragmenttitle.get(position);
    }
}
