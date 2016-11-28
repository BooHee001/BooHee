package com.boohee.boohee.presenter.Shop_Presenter;

import com.boohee.boohee.Bean.shop_Bean.Shop_Goods;
import com.boohee.boohee.View.Shop_View.V_Shop;
import com.boohee.boohee.model.Shop_Model.M_Shop;
import com.boohee.boohee.model.Shop_Model.M_Shop_Impl;

/**
 * Created by as on 2016/11/20.
 */

public class P_Shop_Impl implements P_Shop {
    M_Shop m_shop = new M_Shop_Impl(this);
    private V_Shop v_shop;

    public P_Shop_Impl(V_Shop v_shop) {
        this.v_shop = v_shop;
    }

    @Override
    public void setShopData(Shop_Goods shop_goods) {
        v_shop.setShopData(shop_goods);

    }
    public void initData(){
        m_shop.getData();
    }
}
