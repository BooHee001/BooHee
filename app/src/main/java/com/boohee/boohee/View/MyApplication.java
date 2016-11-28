package com.boohee.boohee.View;

import android.app.Application;

import org.xutils.x;

/**
 * Created by as on 2016/11/21.
 */

public class MyApplication extends Application {
    public static String MyIp = "10.35.162.135";
    public static int userno = 3321;
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);

    }
}
