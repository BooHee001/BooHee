package com.boohee.boohee.presenter.Partner_Presenter;


import com.boohee.boohee.Bean.shop_Bean.partner_Bean.Partner_ViewPager;

import com.boohee.boohee.View.Partner_View.V_Partner_ViewPager;
import com.boohee.boohee.model.Partner_Model.Partner_ViewPager_Model_impl;

/**
 * Created by Huochai on 2016/11/24.
 */

public class P_ViewPager_Partner_Impl implements P_ViewPager_Partner{

    Partner_ViewPager_Model_impl partner_viewPager_model_impl = new Partner_ViewPager_Model_impl(this);
    private V_Partner_ViewPager v_partner_viewPager;

    public P_ViewPager_Partner_Impl(V_Partner_ViewPager v_partner_viewPager) {
        this.v_partner_viewPager = v_partner_viewPager;
    }

    @Override
    public void setViewPagerPartnerBean(Partner_ViewPager partner_viewPager) {
        v_partner_viewPager.setViewPagerPartnerBean(partner_viewPager);
    }

    public void initViewPagerPartner(){
        partner_viewPager_model_impl.initViewPagerPartner();
    }
}
