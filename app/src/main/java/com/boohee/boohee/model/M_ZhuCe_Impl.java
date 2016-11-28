package com.boohee.boohee.model;

import com.boohee.boohee.View.MyApplication;
import com.boohee.boohee.presenter.P_ZhuCe;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by as on 2016/11/28.
 */

public class M_ZhuCe_Impl implements M_ZhuCe {

    private P_ZhuCe p_zhuCe;

    public M_ZhuCe_Impl(P_ZhuCe p_zhuCe) {
        this.p_zhuCe = p_zhuCe;
    }

    @Override
    public void initData(int userno, String uerimg, String username, String pwd, String gander, int statuer, int bitbirthday, int uersweight) {

        RequestParams entiey = new RequestParams("http://"+ MyApplication.MyIp+":8080/MyAndroidDemo//MySerVlet?type=2&userno="+userno+"&uerimg="+uerimg+"&username="+username+"&pwd="+pwd+"&gander="+gander+"&statuer="+statuer+"&bitbirthday="+bitbirthday+"&uersweight="+uersweight);
        x.http().get(entiey, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                p_zhuCe.setData(result);
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

//        http://192.168.100.8:8080/MyAndroidDemo/MySerVlet?type=2&userno=3354&uerimg=aa&username=fff&pwd=9954&gander=nv&statuer=55&bitbirthday=88534&uersweight=55
}
