package com.boohee.boohee.presenter.Shop_Presenter;


import com.boohee.boohee.Bean.Shop_Bean.OrderEntity;

/**
 * Created by Dizner on 2016/11/16.
 */

public interface AliPayPersenter<E> {
    void setData(E result);
    void getData(OrderEntity orderEntity);
}
