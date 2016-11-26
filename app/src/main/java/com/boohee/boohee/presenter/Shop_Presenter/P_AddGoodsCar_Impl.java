package com.boohee.boohee.presenter.Shop_Presenter;

import com.boohee.boohee.View.Shop_View.V_AddGoodsCar;
import com.boohee.boohee.model.Shop_Model.M_AddGoodsCar;
import com.boohee.boohee.model.Shop_Model.M_AddGoodsCar_Impl;

/**
 * Created by as on 2016/11/25.
 */

public class P_AddGoodsCar_Impl implements P_AddGoodsCar {

    private M_AddGoodsCar m_addGoodsCar = new M_AddGoodsCar_Impl(this);
    private V_AddGoodsCar V_addGoodsCar;

    public P_AddGoodsCar_Impl(V_AddGoodsCar V_addGoodsCar) {
        this.V_addGoodsCar = V_addGoodsCar;
    }

    @Override
    public void getResult(String result) {
        V_addGoodsCar.getResult(result);
    }
    public void initData(int userno, String goodsname, String goodsimg, int goodspic, int goodsnum){
        m_addGoodsCar.initData(userno,goodsname,goodsimg,goodspic,goodsnum);
    }
}
