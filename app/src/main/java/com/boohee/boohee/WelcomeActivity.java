package com.boohee.boohee;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.boohee.boohee.View.MainActivity;

import butterknife.BindView;

public class WelcomeActivity extends AppCompatActivity {
    @BindView(R.id.welcome_adimgs)
    public ImageView welcome_adimgs;
    private SharedPreferences sp = null;
    private SharedPreferences.Editor editor = null;
    private static boolean isLogo=false;
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
                    intent.setClass(WelcomeActivity.this, MainActivity.class);
                    break;
                default:
                    break;
            }
            startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        sp=getSharedPreferences("isLogoed",MODE_PRIVATE);
        editor=sp.edit();
        isLogo = sp.getBoolean("isLogo", false);
        if(WelcomeActivity.isLogo){
            handler.sendEmptyMessageAtTime(1,3000);
        }else {
            handler.sendEmptyMessageAtTime(2,3000);
            editor.putBoolean("isLogo",true);
        }

    }
}
