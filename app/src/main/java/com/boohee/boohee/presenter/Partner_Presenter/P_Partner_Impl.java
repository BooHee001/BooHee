package com.boohee.boohee.presenter.Partner_Presenter;

import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.Partner_sift;
import com.boohee.boohee.View.Partner_View.V_Partner_sift;
import com.boohee.boohee.model.Partner_Model.Partner_Model_impl;

/**
 * Created by Huochai on 2016/11/22.
 */

public class P_Partner_Impl implements P_Partner{

    Partner_Model_impl partner_model_impl = new Partner_Model_impl(this);

    private V_Partner_sift v_partner_sift;

    public P_Partner_Impl(V_Partner_sift v_partner_sift) {
        this.v_partner_sift = v_partner_sift;
    }

    @Override
    public void setPartnerBean(Partner_sift partner_sift) {
        v_partner_sift.setPartnerBean(partner_sift);
    }

    public void initPartnerData(){
        partner_model_impl.initPartnerData();
    }

}
