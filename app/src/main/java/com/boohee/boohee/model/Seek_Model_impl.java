package com.boohee.boohee.model;


import com.boohee.boohee.Bean.shop_Bean.partner_Bean.Partner_friends;

import com.boohee.boohee.PhotoBean.Seek_Bean;
import com.boohee.boohee.presenter.P_Seek;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Huochai on 2016/11/28.
 */

public class Seek_Model_impl implements Seek_Model{

    private P_Seek p_seek;

    public Seek_Model_impl(P_Seek p_seek) {
        this.p_seek = p_seek;
    }

    @Override
    public void initSeek() {

//        RequestParams entiey = new RequestParams("http://180.153.222.195/v2/ifoods/keywords?token=w9eSJ5JcC3sySFicgim2&user_key=eabcb76b-eb40-4aa1-b3e8-6529106d6214&app_version=5.6.3.1&app_device=Android&os_version=6.0.1&phone_model=ATH-AL00&channel=huawei");
//        x.http().get(entiey, new Callback.CacheCallback<Seek_Bean>() {
//            @Override
//            public void onSuccess(Seek_Bean result) {
//                p_seek.setSeek_Beans(result);
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//
//            @Override
//            public boolean onCache(Seek_Bean result) {
//                return false;
//            }
//        });


        Retrofit.Builder builder = new Retrofit.Builder();
        //让RE支持RXJava
        Retrofit retrofit = builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                //让RXJava支持Gson
                .addConverterFactory(GsonConverterFactory.create())
                //加载url的域名
                .baseUrl("http://180.153.222.195")
                .build();
//       status_api_version=1.1&token=w9eSJ5JcC3sySFicgim2&user_key=eabcb76b-eb40-4aa1-b3e8-6529106d6214
        //拼接URL
        Seek_ApiService seek_apiService = retrofit.create(Seek_ApiService.class);

        seek_apiService.getSeek("w9eSJ5JcC3sySFicgim2", "eabcb76b-eb40-4aa1-b3e8-6529106d6214")
//                , "5.6.3.1"
                .observeOn(AndroidSchedulers.mainThread())//定义被观察者在哪个线程中
                .subscribeOn(Schedulers.newThread())//定义观察者在哪个线程中
                //将观察者和被观察者联系起来(括号内为观察者)
                .subscribe(new Subscriber<Seek_Bean>() {
                    @Override
                    //这是个标记
                    public void onCompleted() {

                    }

                    @Override
                    //失败的时候
                    public void onError(Throwable e) {

                    }

                    @Override
                    //只有持有上面的标记才会执行这个
                    public void onNext(Seek_Bean seek_bean) {
                        p_seek.setSeek_Beans(seek_bean);
                    }
                });


    }
}
