package com.boohee.boohee.presenter.Shop_Presenter;

import android.content.Context;

import com.boohee.boohee.Bean.shop_Bean.GoodsCarBean;
import com.boohee.boohee.View.Shop_View.V_ShowGoodsCar;
import com.boohee.boohee.model.Shop_Model.M_ShowGoodsCar;
import com.boohee.boohee.model.Shop_Model.M_ShowGoodsCar_Impl;

import java.util.List;

/**
 * Created by as on 2016/11/25.
 */

public class P_ShowGoodsCar_Impl implements P_ShowGoodsCar {
    M_ShowGoodsCar m_showGoodsCar = new M_ShowGoodsCar_Impl(this);
    V_ShowGoodsCar v_showGoodsCar;

    public P_ShowGoodsCar_Impl(V_ShowGoodsCar v_showGoodsCar) {
        this.v_showGoodsCar = v_showGoodsCar;
    }

    @Override
    public void getData(List<GoodsCarBean> goodsCarBeanList) {
        v_showGoodsCar.getData(goodsCarBeanList);
    }
    public void setData(int userno,Context context){
        m_showGoodsCar.getData(userno,context);
    }
}
