package com.boohee.boohee.model.Shop_Model;

import com.boohee.boohee.Bean.Shop_Bean.GoodsCarBean;
import com.boohee.boohee.presenter.Shop_Presenter.P_ShowGoodsCar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by as on 2016/11/25.
 */

public class M_ShowGoodsCar_Impl implements M_ShowGoodsCar {

    private P_ShowGoodsCar p_showGoodsCar;
    public M_ShowGoodsCar_Impl(P_ShowGoodsCar p_showGoodsCar) {
        this.p_showGoodsCar = p_showGoodsCar;
    }
    @Override
    public void getData(final int userno) {

        RequestParams entiey = new RequestParams("http://192.168.31.188:8080/MyAndroidDemo/MySerVlet?type=4&userno="+userno);
        x.http().post(entiey, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                final List<GoodsCarBean> goodsCarBeanList = new ArrayList<>();
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String goodsimg = jsonObject.optString("goodsimg");
                        String goodsname = jsonObject.optString("goodsname");
                        int goodsnum = jsonObject.optInt("goodsnum");
                        int goodspic = jsonObject.optInt("goodspic");
                        int userno = jsonObject.optInt("userno");
                        GoodsCarBean goodsCarBean = new GoodsCarBean(goodsimg, goodsname, goodsnum, goodspic, userno);
                        goodsCarBeanList.add(goodsCarBean);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                p_showGoodsCar.getData(goodsCarBeanList);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
//        try {
//        final List<GoodsCarBean> goodsCarBeanList = new ArrayList<>();
//        Retrofit.Builder builder = new Retrofit.Builder();
//        Retrofit retrofit = builder.baseUrl("http://192.168.31.188:8080")
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create()).build();
//            Shop_ApiSerVice apiService = retrofit.create(Shop_ApiSerVice.class);
//            apiService.getGoodsCarBeanList(userno)
//                    .observeOn(AndroidSchedulers.mainThread())//定义被观察者在哪个线程中
//                    .subscribeOn(Schedulers.newThread())//定义观察者在哪个线程中
//                    .subscribe(new Subscriber<String>() {
//                        @Override
//                        public void onCompleted() {
//
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//                            e.printStackTrace();
//                        }
//
//                        @Override
//                        public void onNext(String s) {
//                            try {
//                                JSONArray jsonArray = new JSONArray(s);
//                                for (int i = 0; i < jsonArray.length(); i++) {
//                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
//                                    String goodsimg = jsonObject.optString("goodsimg");
//                                    String goodsname = jsonObject.optString("goodsname");
//                                    int goodsnum = jsonObject.optInt("goodsnum");
//                                    int goodspic = jsonObject.optInt("goodspic");
//                                    int userno = jsonObject.optInt("userno");
//                                    GoodsCarBean goodsCarBean = new GoodsCarBean(goodsimg, goodsname, goodsnum, goodspic, userno);
//                                    goodsCarBeanList.add(goodsCarBean);
//                                }
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                            p_showGoodsCar.getData(goodsCarBeanList);
//                        }
//                    });
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
