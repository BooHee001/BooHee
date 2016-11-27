package com.boohee.boohee.model.Shop_Model;

import com.boohee.boohee.View.MyApplication;
import com.boohee.boohee.model.ApiService;
import com.boohee.boohee.presenter.Shop_Presenter.P_AddGoodsCar;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by as on 2016/11/25.
 */

public class M_AddGoodsCar_Impl implements M_AddGoodsCar {
    private P_AddGoodsCar p_addGoodsCar;

    public M_AddGoodsCar_Impl(P_AddGoodsCar p_addGoodsCar) {
        this.p_addGoodsCar = p_addGoodsCar;
    }

    @Override
    public void initData(int userno, String goodsname, String goodsimg, int goodspic, int goodsnum) {
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl("http://"+ MyApplication.MyIp+":8080")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
        Shop_ApiSerVice apiService = retrofit.create(Shop_ApiSerVice.class);
        apiService.addGoodsCar(userno, goodsname, goodsimg, goodspic, goodsnum)
                .observeOn(AndroidSchedulers.mainThread())//定义被观察者在哪个线程中
                .subscribeOn(Schedulers.newThread())//定义观察者在哪个线程中
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        p_addGoodsCar.getResult(s);
                    }
                });
    }
}
