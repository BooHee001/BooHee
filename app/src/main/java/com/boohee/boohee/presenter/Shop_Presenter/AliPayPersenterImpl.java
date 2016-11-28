package com.boohee.boohee.presenter.Shop_Presenter;

import android.app.Activity;

import com.boohee.boohee.Bean.shop_Bean.OrderEntity;
import com.boohee.boohee.Utils.Shop_Utils.PayResult;
import com.boohee.boohee.View.Shop_View.Alipay_view;
import com.boohee.boohee.model.Shop_Model.AlipayService;

/**
 * Created by Dizner on 2016/11/16.
 */

public class AliPayPersenterImpl implements AliPayPersenter {
    AlipayService service;
    Alipay_view view;
//    Alipay_modeimpl alipay_model;
    private Activity mActivity;

    public AliPayPersenterImpl(Alipay_view view, Activity mActivity) {
        this.view = view;
        this.mActivity=mActivity;
        service=new AlipayService(this,mActivity);
//        alipay_model=new Alipay_modeimpl(mActivity);
    }

    @Override
    public void setData(Object result) {
        view.getDate((PayResult) result);
    }

    @Override
    public void getData(OrderEntity orderEntity) {
        try {
            service.pay(orderEntity);
//            alipay_model.payV2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
