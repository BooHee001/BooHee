package com.boohee.boohee.presenter.Shop_Presenter;

import com.boohee.boohee.View.Shop_View.V_RemoveGoodsCar;
import com.boohee.boohee.model.Shop_Model.M_RemoveGoodsCar;
import com.boohee.boohee.model.Shop_Model.M_RemoverGoodsCar_Impl;

/**
 * Created by as on 2016/11/26.
 */

public class P_RemoveGoodsCar_Impl implements  P_RemoveGoodsCar {
    M_RemoveGoodsCar m_removeGoodsCar = new M_RemoverGoodsCar_Impl(this);
    private V_RemoveGoodsCar v_removeGoodsCar;

    public P_RemoveGoodsCar_Impl(V_RemoveGoodsCar v_removeGoodsCar) {
        this.v_removeGoodsCar = v_removeGoodsCar;
    }

    @Override
    public void getResult(String result) {
        v_removeGoodsCar.getResult(result);
    }
    public void removeData(int userno,String goodsimg){
        m_removeGoodsCar.removeData(userno,goodsimg);
    }
}
