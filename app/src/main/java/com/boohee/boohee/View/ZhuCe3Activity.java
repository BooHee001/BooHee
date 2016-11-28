package com.boohee.boohee.View;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.boohee.boohee.R;
import com.boohee.boohee.presenter.P_ZhuCe;
import com.boohee.boohee.presenter.P_ZhuCe_Impl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhuCe3Activity extends AppCompatActivity {

    private HorizontalScrollView ruler;
    private LinearLayout rulerlayout, all_layout;
    private TextView user_birth_value;
    private int begin;

    //用来
//    private String birthyear = "56";
    private long time = 0;
    private int screenWidth;
    private boolean isFirst = true;
    int libs =0;


    @BindView(R.id.ZhuCe_Loading)
    View ZhuCe_Loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce3);

        ButterKnife.bind(this);
        ZhuCe_Loading.setVisibility(View.GONE);

        user_birth_value = (TextView) findViewById(R.id.user_birth_value);
        //开始时textView显示的数字
        user_birth_value.setText("100");
        ruler = (HorizontalScrollView) findViewById(R.id.birthruler);
        rulerlayout = (LinearLayout) findViewById(R.id.ruler_layout);
        ruler.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                //用来改变当前text的值
                user_birth_value.setText(String.valueOf(begin
                        + (int) Math.round(ruler.getScrollX()) / 20));
                libs =begin + (int) Math.round(ruler.getScrollX()) / 20;
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        break;
//                    case MotionEvent.ACTION_UP:
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                user_birth_value.setText(String.valueOf(beginYear
//                                        + (int) Math.ceil((ruler.getScrollX()) / 20)));
//                                birthyear = String.valueOf((int) (beginYear + Math
//                                        .ceil((ruler.getScrollX()) / 20)));
//                                try {
//                                    time = (new SimpleDateFormat("yyyy")
//                                            .parse(String.valueOf(birthyear)))
//                                            .getTime();
//                                } catch (ParseException e) {
//                                    e.printStackTrace();
////                                }
//                            }
//                        }, 1000);
//                        break;
                }
                return false;
            }

        });
    }
    public void back(View v){
        finish();
    }

    public void next(View v){
        ZhuCe_Loading.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        final int userno = intent.getIntExtra("zhuce_userno", -1);
        String pwd = intent.getStringExtra("zhuce_pwd");
        String gander = intent.getStringExtra("gander");
        int height = intent.getIntExtra("height", -1);
        P_ZhuCe_Impl p_zhuCe_ = new P_ZhuCe_Impl(new V_ZhuCe() {
            @Override
            public void setData(String resutl) {

                if("success".equals(resutl)){
                    ZhuCe_Loading.setVisibility(View.GONE);
                    Intent intent = new Intent(ZhuCe3Activity.this,LoginActivity.class);
                    intent.putExtra("userno", userno);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(ZhuCe3Activity.this, "注册失败", Toast.LENGTH_SHORT).show();
                }

            }
        });
        p_zhuCe_.initData(userno,"aa","wawu",pwd,gander,height,libs,65);
    }

    //oncreate方法中获取屏幕的宽和高都为0但在该方法中可以获取到
    //用来获取屏幕的宽和高
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (isFirst) {
            screenWidth = ruler.getWidth();
            constructRuler();
            isFirst = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                scroll();
            }
        }, 100);
    }

    private void scroll() {
//        让当前视图便宜之xy处
        ruler.smoothScrollTo((100 - begin) * 20, 0);
    }


    @SuppressWarnings("deprecation")
    private void constructRuler() {
//        int year = new Date().getYear();
//        if (year < 2015)
//            year = 2010;
//        beginYear = year / 10 * 10 - 150;
        //从那开始
        begin =1927;
        View leftview = (View) LayoutInflater.from(this).inflate(
                R.layout.blankhrulerunit, null);
        //用来绘制尺子从哪开始
        leftview.setLayoutParams(new ViewGroup.LayoutParams(screenWidth / 2,
                ViewGroup.LayoutParams.MATCH_PARENT));
        rulerlayout.addView(leftview);
//        用来控制尺子的长度
        for (int i = 0; i < 13; i++) {
            View view = (View) LayoutInflater.from(this).inflate(
                    R.layout.hrulerunit, null);
            view.setLayoutParams(new ViewGroup.LayoutParams(200,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            TextView tv = (TextView) view.findViewById(R.id.hrulerunit);
            tv.setText(String.valueOf(begin + i * 10));
            rulerlayout.addView(view);
        }
        View rightview = (View) LayoutInflater.from(this).inflate(
                R.layout.blankhrulerunit, null);
        rightview.setLayoutParams(new ViewGroup.LayoutParams(screenWidth / 2,
                ViewGroup.LayoutParams.MATCH_PARENT));
        rulerlayout.addView(rightview);
    }

}
