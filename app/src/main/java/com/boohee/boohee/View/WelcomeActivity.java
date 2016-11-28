package com.boohee.boohee.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.boohee.boohee.Bean.shop_Bean.UserBean;
import com.boohee.boohee.R;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import butterknife.BindView;

public class WelcomeActivity extends AppCompatActivity {
    @BindView(R.id.welcome_adimgs)
    public ImageView welcome_adimgs;
    private SharedPreferences sp = null;
    private SharedPreferences.Editor editor = null;
    private static boolean isLogo=false;
    private DbManager db;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent=new Intent();
            switch (msg.what) {
                case 1:
                    intent.setClass(WelcomeActivity.this, MainActivity.class);
                    break;
                case 2:
                    intent.setClass(WelcomeActivity.this, LoginActivity.class);

//                    db= x.getDb(new DbManager.DaoConfig().setDbName("user"));
//                    try {
//                        db.saveOrUpdate(new UserBean(1,"admin","admin"));
//                    } catch (DbException e) {
//                        e.printStackTrace();
//                    }
                    break;
                default:
                    break;
            }
            startActivity(intent);
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION//隐藏状态栏的布局
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN//内容布局填满屏幕
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION//隐藏状态栏
                        | View.SYSTEM_UI_FLAG_FULLSCREEN//内容全屏展示
                        | View.SYSTEM_UI_FLAG_IMMERSIVE
        );
        setContentView(R.layout.activity_welcome);
        sp=getSharedPreferences("isLogoed",MODE_PRIVATE);
        editor=sp.edit();
        isLogo = sp.getBoolean("isLogo", false);
        if(WelcomeActivity.isLogo){
            handler.sendEmptyMessageDelayed(1,3000);
        }else {
            handler.sendEmptyMessageDelayed(2,3000);
            editor.putBoolean("isLogo",true);
            editor.commit();
        }

    }
}
