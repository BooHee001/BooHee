package com.boohee.boohee.presenter.Shop_Presenter;

import android.content.Context;

import com.boohee.boohee.Bean.shop_Bean.GoodsCarBean;
import com.boohee.boohee.View.Shop_View.V_ShowGoodsCarForImg;
import com.boohee.boohee.model.Shop_Model.M_ShowGoodsCarForImg_Impl;

/**
 * Created by as on 2016/11/26.
 */

public class P_ShowGoodsCarForImg_Impl implements P_ShowGoodsCarForImg{
    M_ShowGoodsCarForImg_Impl mShowGoodsCarForImg = new M_ShowGoodsCarForImg_Impl(this);
    private V_ShowGoodsCarForImg v_showGoodsCarForImg;

    public P_ShowGoodsCarForImg_Impl(V_ShowGoodsCarForImg v_showGoodsCarForImg) {
        this.v_showGoodsCarForImg = v_showGoodsCarForImg;
    }

    @Override
    public void setData(GoodsCarBean goodsCarBean) {
        v_showGoodsCarForImg.setData(goodsCarBean);
    }
    public void getData(int userno, String goodsimg, Context context){
        mShowGoodsCarForImg.getData(userno,goodsimg,context);
    }
}
