package com.boohee.boohee.model;

import com.boohee.boohee.Bean.shop_Bean.UserBean;
import com.boohee.boohee.View.MyApplication;
import com.boohee.boohee.presenter.P_Login;

import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by as on 2016/11/28.
 */

public class M_Login_Impl implements M_Login {
    private P_Login p_login;
    private DbManager db;
    private UserBean userBeen=null;

    public M_Login_Impl(P_Login p_login) {
        this.p_login = p_login;
//        db=x.getDb(new DbManager.DaoConfig().setDbName("user"));
    }

    @Override
    public void getResult(int userno, String pwd) {
//        try {
//            userBeen = db.selector(UserBean.class).where(WhereBuilder.b("name","=","admin")).and(WhereBuilder.b("psw","=","admin")).findFirst();
//            p_login.getResult("success");
//        } catch (DbException e) {
//            e.printStackTrace();
//            logo(userno,pwd);
//        }
//        if (userBeen==null) {
            logo(userno,pwd);
//        }
    }

    private void logo(int userno, String pwd) {
        RequestParams entiey = new RequestParams("http://"+ MyApplication.MyIp+":8080/MyAndroidDemo/MySerVlet?type=1&userno="+userno+"&pwd="+pwd);
        x.http().get(entiey, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                p_login.getResult(result);

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
