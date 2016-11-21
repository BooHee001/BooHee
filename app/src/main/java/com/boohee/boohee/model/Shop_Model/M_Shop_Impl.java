package com.boohee.boohee.model.Shop_Model;

import android.util.Log;

import com.boohee.boohee.Bean.Shop_Bean.Shop_Goods;
import com.boohee.boohee.presenter.Shop_Presenter.P_Shop;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by as on 2016/11/20.
 */

public class M_Shop_Impl implements M_Shop {
    P_Shop p_shop;

    public M_Shop_Impl(P_Shop p_shop) {
        this.p_shop = p_shop;
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://180.153.222.195")
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    Shop_ApiSerVice shop_apiSerVice = retrofit.create(Shop_ApiSerVice.class);

    @Override
    public void getData() {

        Observable<Shop_Goods> observable = shop_apiSerVice.getShopGoods(4, "w9eSJ5JcC3sySFicgim2", "eabcb76b-eb40-4aa1-b3e8-6529106d6214");
        observable
                .observeOn(AndroidSchedulers.mainThread())//定义被观察者在哪个线程中
                .subscribeOn(Schedulers.newThread())//定义观察者在哪个线程中
                .subscribe(new Subscriber<Shop_Goods>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("test",e.getMessage());

                    }

                    @Override
                    public void onNext(Shop_Goods shop_goods) {
                        p_shop.setShopData(shop_goods);
                    }
                });

    }
}
