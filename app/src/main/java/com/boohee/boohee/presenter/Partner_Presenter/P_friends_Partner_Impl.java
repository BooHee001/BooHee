package com.boohee.boohee.presenter.Partner_Presenter;

import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.Partner_friends;
import com.boohee.boohee.View.Partner_View.V_Partner_friends;
import com.boohee.boohee.model.Partner_Model.Partner_friends_Model_impl;

/**
 * Created by Huochai on 2016/11/24.
 */

public class P_friends_Partner_Impl implements P_friends_Partner{

    Partner_friends_Model_impl partner_friends_model_impl = new Partner_friends_Model_impl(this);
    private V_Partner_friends v_partner_friends;
    public P_friends_Partner_Impl(V_Partner_friends v_partner_friends) {
        this.v_partner_friends = v_partner_friends;
    }

    @Override
    public void setfriendsPartnerBean(Partner_friends partner_friends) {
            v_partner_friends.setFriendsPartnerBean(partner_friends);
    }

    public void initFriendsPartner(){
        partner_friends_model_impl.initFriendsPartner();
    }

}
