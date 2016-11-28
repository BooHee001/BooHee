package com.boohee.boohee.model.Partner_Model;

import com.boohee.boohee.Bean.shop_Bean.partner_Bean.Partner_ViewPager;
import com.boohee.boohee.presenter.Partner_Presenter.P_ViewPager_Partner;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Huochai on 2016/11/24.
 */

public class Partner_ViewPager_Model_impl implements Partner_ViewPager_Model{

    private P_ViewPager_Partner p_viewPager_partner;

    public Partner_ViewPager_Model_impl(P_ViewPager_Partner p_viewPager_partner) {
        this.p_viewPager_partner = p_viewPager_partner;
    }

    @Override
    public void initViewPagerPartner() {
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://139.196.2.133")
                .build();

        Partner_ViewPager_ApiService partner_viewPager_apiService = retrofit.create(Partner_ViewPager_ApiService.class);

        partner_viewPager_apiService.getPartnerV("b6LUSVkfgNK9sWjX2SMV","6a50362e-ab24-4240-b630-581de4dc240c","5.6.3.1")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<Partner_ViewPager>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Partner_ViewPager partner_viewPager) {

                    }
                });



    }
}
