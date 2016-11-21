package com.boohee.boohee.model.Shop_Model;

import com.boohee.boohee.Bean.Shop_Bean.Shop_Goods;
import com.boohee.boohee.Bean.Shop_Bean.Shop_Goods_Item;
import com.boohee.boohee.presenter.Shop_Presenter.P_Shop_Item;

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
    public void getData(String exhibit_type,String exhibit) {
        String uri ="http://180.153.222.195/api/v1/"+exhibit_type+"/"+exhibit+"?page=1&token=w9eSJ5JcC3sySFicgim2&user_key=eabcb76b-eb40-4aa1-b3e8-6529106d6214";
        RequestParams entity = new RequestParams(uri);
        x.http().get(entity, new Callback.CacheCallback<Shop_Goods_Item>() {
            @Override
            public void onSuccess(Shop_Goods_Item result) {
                p_Shop_Item.setData(result);
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
            public boolean onCache(Shop_Goods_Item result) {
                return false;
            }
        });
    }
}
