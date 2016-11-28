package com.boohee.boohee.model.Shop_Model;

import com.boohee.boohee.Bean.shop_Bean.Shop_Goods_Item;
import com.boohee.boohee.presenter.Shop_Presenter.P_Shop_Item;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by as on 2016/11/21.
 */

public class M_Shop_Item_Impl implements M_Shop_item {
    P_Shop_Item p_Shop_Item;

    public M_Shop_Item_Impl(P_Shop_Item p_Shop_Item) {
        this.p_Shop_Item = p_Shop_Item;
    }

    @Override
    public void getData(String exhibit_type,String exhibit,int page) {
        String uri ="http://180.153.222.195/api/v1/labels/"+exhibit_type+"?page="+page+"&token=w9eSJ5JcC3sySFicgim2&user_key=eabcb76b-eb40-4aa1-b3e8-6529106d6214&app_version=5.6.3.1&app_device=Android&os_version=6.0.1&phone_model=ATH-AL00&channel=huawei&app_key=one";
        RequestParams entity = new RequestParams(uri);
        x.http().get(entity, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Shop_Goods_Item shop_goods_item = gson.fromJson(result, Shop_Goods_Item.class);
                p_Shop_Item.setData(shop_goods_item);

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
