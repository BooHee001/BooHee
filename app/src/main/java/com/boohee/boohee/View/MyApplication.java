package com.boohee.boohee.View;

import android.app.Application;

import org.xutils.x;

/**
 * Created by as on 2016/11/21.
 */

public class MyApplication extends Application {
    public static String MyIp = "192.168.100.8";
    public static int userno =0;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);

    }
}
