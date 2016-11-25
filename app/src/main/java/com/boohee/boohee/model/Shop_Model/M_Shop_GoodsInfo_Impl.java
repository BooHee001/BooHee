package com.boohee.boohee.model.Shop_Model;

import com.boohee.boohee.Bean.Shop_Bean.Shop_GoodsInfo_Bean;
import com.boohee.boohee.presenter.Shop_Presenter.P_Shop_GoodsInfo;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by as on 2016/11/23.
 */

public class M_Shop_GoodsInfo_Impl implements M_Shop_GoodsInfo {
    private P_Shop_GoodsInfo p_Shop_GoodsInfo;

    public M_Shop_GoodsInfo_Impl(P_Shop_GoodsInfo p_Shop_GoodsInfo) {
        this.p_Shop_GoodsInfo = p_Shop_GoodsInfo;
    }

    @Override
    public void initData(int id) {
        String Url ="http://180.153.222.195/api/v1/goods/"+id+"?token=w9eSJ5JcC3sySFicgim2&user_key=eabcb76b-eb40-4aa1-b3e8-6529106d6214&app_version=5.6.3.1&app_device=Android&os_version=6.0.1&phone_model=ATH-AL00&channel=huawei&app_key=one";
        RequestParams entity = new RequestParams(Url);
        x.http().get(entity, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Shop_GoodsInfo_Bean shop_goodsInfo_bean = gson.fromJson(result, Shop_GoodsInfo_Bean.class);
                p_Shop_GoodsInfo.setData(shop_goodsInfo_bean);
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
    }
}
