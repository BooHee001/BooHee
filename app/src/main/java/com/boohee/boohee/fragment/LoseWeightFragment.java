package com.boohee.boohee.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boohee.boohee.R;
import com.bumptech.glide.Glide;
import com.github.lzyzsd.circleprogress.ArcProgress;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.ColumnChartView;

/**
 * Created by Dizner on 2016/11/18.
 */

public class LoseWeightFragment extends Fragment {
    private View view;
    private NestedScrollView home_cardgroup;
    private ArcProgress progress;
    private TextView textView;
    private int i=20;
    private ViewPager home_showPhoto;
    private PagerAdapter adapter;
    private int width;
    private int hight;

    private RelativeLayout home_welcome_imgs;
    private Bitmap bitmap=null;
    private View decorView;
    private final static String[] months = new String[] { "早", "午", "晚",
            "加", "运动"};

    private ColumnChartView columnChart;
    private ColumnChartData columnData;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.loseweight_fragment, container, false);
            progress= (ArcProgress) view.findViewById(R.id.weight_progress);
            columnChart= (ColumnChartView) view.findViewById(R.id.home_tab);
            home_welcome_imgs= (RelativeLayout) view.findViewById(R.id.home_welcome_imgs);
            textView= (TextView) view.findViewById(R.id.textView);
            decorView = getActivity().getWindow().getDecorView();
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        setAnim(300);
                }
            });
            home_showPhoto= (ViewPager) getActivity().findViewById(R.id.home_showPhoto);
            width=getActivity(). getWindowManager().getDefaultDisplay().getWidth();
            hight=getActivity(). getWindowManager().getDefaultDisplay().getHeight();
//            home_showPhoto.setLayoutParams(new CoordinatorLayout.LayoutParams(width,hight));
            progress.setMax(60);
            home_cardgroup= (NestedScrollView) view.findViewById(R.id.home_cardgroup);
//            setAnim();
            dataInit();
        }

        return view;
    }
    private void setAnim(int duration) {
        ObjectAnimator animator=ObjectAnimator.ofFloat(home_showPhoto,"translationY",-hight,0);
        animator.setDuration(duration);



        animator.addListener(new Animator.AnimatorListener() {
           @Override
           public void onAnimationStart(Animator animation) {

           }

           @Override
           public void onAnimationEnd(Animator animation) {
               decorView.setSystemUiVisibility(
                       View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION//隐藏状态栏的布局
                               | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN//内容布局填满屏幕
//                                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION//隐藏状态栏
                               | View.SYSTEM_UI_FLAG_FULLSCREEN//内容全屏展示
                               | View.SYSTEM_UI_FLAG_IMMERSIVE
               );
           }

           @Override
           public void onAnimationCancel(Animator animation) {

           }

           @Override
           public void onAnimationRepeat(Animator animation) {

           }
       });
        animator.start();

    }
    public void setWelcomeImgs(final String url){
            new Thread(){
                @Override
                public void run() {

                    try {
                        bitmap= Glide.with(LoseWeightFragment.this)
                                .load(url)
                                .asBitmap()
                                .centerCrop()
                                .into(width, home_welcome_imgs.getHeight())
                                .get();
                        handler.sendEmptyMessage(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }.start();


    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            home_welcome_imgs.setBackground(new BitmapDrawable(bitmap));
        }
    };

    private void dataInit() {
        columnChart.setZoomEnabled(false);
        int numSubcolumns = 1;
        int numColumns = months.length;

        List<AxisValue> axisValues = new ArrayList<>();
        List<Column> columns = new ArrayList<>();
        List<SubcolumnValue> values;
        for (int i = 0; i <months.length; ++i) {

            values = new ArrayList<>();
            //设置数据
            for (int j = 0; j < 1; ++j) {
                values.add(new SubcolumnValue((float) Math.random() * 50f + 5,
                        ChartUtils.pickColor()));
            }
// 点击柱状图就展示数据量
            axisValues.add(new AxisValue(i).setLabel(months[i]));
            columns.add(new Column(values).setHasLabels(false).setHasLabelsOnlyForSelected(false));
        }

        columnData = new ColumnChartData(columns);
        columnData.setAxisXBottom(new Axis(axisValues).setTextSize(8).setLineColor(Color.WHITE));
        columnData.setAxisYLeft(null);
        columnChart.setColumnChartData(columnData);
    }
}
