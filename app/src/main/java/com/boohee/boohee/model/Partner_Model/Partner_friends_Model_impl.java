package com.boohee.boohee.model.Partner_Model;

import com.boohee.boohee.Bean.shop_Bean.partner_Bean.Partner_friends;
import com.boohee.boohee.presenter.Partner_Presenter.P_friends_Partner;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Huochai on 2016/11/24.
 */

public class Partner_friends_Model_impl implements Partner_friends_Model{

    private P_friends_Partner p_friends_partner;

    public Partner_friends_Model_impl(P_friends_Partner p_friends_partner) {
        this.p_friends_partner = p_friends_partner;
    }

    @Override
    public void initFriendsPartner() {
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
        Partner_friends_ApiService partner_friends_ApiService = retrofit.create(Partner_friends_ApiService.class);

        partner_friends_ApiService.getPartnerf("1.1", "w9eSJ5JcC3sySFicgim2", "eabcb76b-eb40-4aa1-b3e8-6529106d6214")
                .observeOn(AndroidSchedulers.mainThread())//定义被观察者在哪个线程中
                .subscribeOn(Schedulers.newThread())//定义观察者在哪个线程中
                //将观察者和被观察者联系起来(括号内为观察者)
                .subscribe(new Subscriber<Partner_friends>() {
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
                    public void onNext(Partner_friends partner_friends) {
                        p_friends_partner.setfriendsPartnerBean(partner_friends);
                    }
                });


    }
}
