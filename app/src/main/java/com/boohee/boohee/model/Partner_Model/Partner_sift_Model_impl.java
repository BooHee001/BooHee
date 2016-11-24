package com.boohee.boohee.model.Partner_Model;

import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.Partner_sift;
import com.boohee.boohee.presenter.Partner_Presenter.P_sift_Partner;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Huochai on 2016/11/22.
 */

public class Partner_sift_Model_impl implements Partner_sift_Model {


    private P_sift_Partner p_partner;

    public Partner_sift_Model_impl(P_sift_Partner p_partner) {
        this.p_partner = p_partner;
    }

    @Override
    public void initPartnerData() {
        Retrofit.Builder builder = new Retrofit.Builder();
        //让RE支持RXJava
        Retrofit retrofit = builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                //让RXJava支持Gson
                .addConverterFactory(GsonConverterFactory.create())
                //加载url的域名
                .baseUrl("http://180.153.222.195")
                .build();
//        slug=hot_posts&token=b6LUSVkfgNK9sWjX2SMV&user_key=6a50362e-ab24-4240-b630-581de4dc240c
        //拼接URL
        Partner_sift_ApiService partner_sift_apiService = retrofit.create(Partner_sift_ApiService.class);

        partner_sift_apiService.getPartner("hot_posts", "b6LUSVkfgNK9sWjX2SMV", "6a50362e-ab24-4240-b630-581de4dc240c")
                .observeOn(AndroidSchedulers.mainThread())//定义被观察者在哪个线程中
                .subscribeOn(Schedulers.newThread())//定义观察者在哪个线程中
                //将观察者和被观察者联系起来(括号内为观察者)
                .subscribe(new Subscriber<Partner_sift>() {
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
                    public void onNext(Partner_sift partner_sift) {
                        p_partner.setPartnerBean(partner_sift);
                    }
                });


    }
}
