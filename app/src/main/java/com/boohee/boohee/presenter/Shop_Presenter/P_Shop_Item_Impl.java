package com.boohee.boohee.presenter.Shop_Presenter;

import android.util.Log;

import com.boohee.boohee.Bean.Shop_Bean.Shop_Goods_Item;
import com.boohee.boohee.View.Shop_View.V_Shop_Item;
import com.boohee.boohee.model.Shop_Model.M_Shop_Item_Impl;
import com.boohee.boohee.model.Shop_Model.M_Shop_item;

/**
 * Created by as on 2016/11/21.
 */

public class P_Shop_Item_Impl implements P_Shop_Item {
    M_Shop_item m_shop_item = new M_Shop_Item_Impl(this);
    V_Shop_Item v_shop_item;

    public P_Shop_Item_Impl(V_Shop_Item v_shop_item) {
        this.v_shop_item = v_shop_item;
    }

    @Override
    public void setData(Shop_Goods_Item shop_goods_item) {
        v_shop_item.setData(shop_goods_item);
    }

    public void getData(String exhibit_type,String exhibit,int page){
        m_shop_item.getData(exhibit_type,exhibit,page);
    }
}
