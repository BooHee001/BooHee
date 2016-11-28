package com.boohee.boohee.presenter.Shop_Presenter;

import com.boohee.boohee.Bean.shop_Bean.Shop_GoodsInfo_Bean;
import com.boohee.boohee.View.Shop_View.V_Shop_GoodsInfo;
import com.boohee.boohee.model.Shop_Model.M_Shop_GoodsInfo;
import com.boohee.boohee.model.Shop_Model.M_Shop_GoodsInfo_Impl;

/**
 * Created by as on 2016/11/23.
 */

public class P_Shop_GoodsInfo_Impl implements P_Shop_GoodsInfo {
    M_Shop_GoodsInfo m_shop_goodsInfo = new M_Shop_GoodsInfo_Impl(this);

    private V_Shop_GoodsInfo v_shop_goodsInfo;

    public P_Shop_GoodsInfo_Impl(V_Shop_GoodsInfo v_shop_goodsInfo) {
        this.v_shop_goodsInfo = v_shop_goodsInfo;
    }
    @Override
    public void setData(Shop_GoodsInfo_Bean shop_goodsInfo_bean) {
        v_shop_goodsInfo.setData(shop_goodsInfo_bean);

    }
    public void initData(int id){
        m_shop_goodsInfo.initData(id);
    }
}
