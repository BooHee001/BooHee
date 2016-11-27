package com.boohee.boohee.model.Shop_Model;

import com.boohee.boohee.presenter.Shop_Presenter.P_RemoveGoodsCar;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by as on 2016/11/26.
 */

public class M_RemoverGoodsCar_Impl implements M_RemoveGoodsCar {
    private P_RemoveGoodsCar p_RemoveGoodsCar;

    public M_RemoverGoodsCar_Impl(P_RemoveGoodsCar p_RemoveGoodsCar) {
        this.p_RemoveGoodsCar = p_RemoveGoodsCar;
    }

    @Override
    public void removeData(int userno, String goodsimg) {
        RequestParams entiey = new RequestParams("http://172.18.188.5:8080/MyAndroidDemo/MySerVlet?type=6&userno="+userno+"&goodsimg="+goodsimg);
        x.http().get(entiey, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                p_RemoveGoodsCar.getResult(result);
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
