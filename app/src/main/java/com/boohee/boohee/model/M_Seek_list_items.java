package com.boohee.boohee.model;

import com.boohee.boohee.presenter.P_Seek_list_item;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Huochai on 2016/11/28.
 */

public class M_Seek_list_items implements M_Seek_list_item{

    private P_Seek_list_item p_seek_list_item;

    public M_Seek_list_items(P_Seek_list_item p_seek_list_item) {
        this.p_seek_list_item = p_seek_list_item;
    }

    @Override
    public void seek_list_item(String seacher) {
        RequestParams entiey = new RequestParams("http://180.153.222.195/fb/v1/foods/fast_search?q="+seacher+"&token=w9eSJ5JcC3sySFicgim2&user_key=eabcb76b-eb40-4aa1-b3e8-6529106d6214");
        x.http().get(entiey, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                p_seek_list_item.getSeacher(result);
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
