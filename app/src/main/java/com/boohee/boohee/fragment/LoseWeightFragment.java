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
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boohee.boohee.Bean.Shop_Bean.FoodLog;
import com.boohee.boohee.Bean.Shop_Bean.WeightLog;
import com.boohee.boohee.R;
import com.bumptech.glide.Glide;
import com.github.lzyzsd.circleprogress.ArcProgress;

import org.xutils.DbManager;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * Created by Dizner on 2016/11/18.
 */

public class LoseWeightFragment extends Fragment {
    private final static String[] months = new String[] { "早", "午", "晚",
            "加", "运动"};
    private View view;
    private NestedScrollView home_cardgroup;
    private ArcProgress progress;
    private TextView textView;
    private ViewPager home_showPhoto;
    private int width;
    private int hight;
    private RelativeLayout home_welcome_imgs;
    private Bitmap bitmap=null;
    private View decorView;
    private DbManager db;
    private ColumnChartView columnChart;
    private LineChartView lineChartView;
    private LineChartData lineChartData;
    //相关界面数据的更新，步数，体重记录，食物计数；
    private TextView setp_count,weught_count,food_count;
    //步数进度条
    private ProgressBar setp_progressBar;
    private ColumnChartData columnData;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            home_welcome_imgs.setBackground(new BitmapDrawable(bitmap));
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.loseweight_fragment, container, false);
           initView();
            //设置状态栏属性，获取当前屏幕的高度和宽度
            decorView = getActivity().getWindow().getDecorView();
            width=getActivity(). getWindowManager().getDefaultDisplay().getWidth();
            hight=getActivity(). getWindowManager().getDefaultDisplay().getHeight();
            //数据库初始化
            db=x.getDb(new DbManager.DaoConfig().setDbName("foodLog"));
            //临时写入数据的方法
            try {
                //食物记录写入
                db.save(new FoodLog(1,1,56));
                db.save(new FoodLog(2,2,53));
                db.save(new FoodLog(3,3,52));
                db.save(new FoodLog(4,4,51));
                db.save(new FoodLog(5,5,58));
            } catch (DbException e) {
                e.printStackTrace();
            }

            db=x.getDb(new DbManager.DaoConfig().setDbName("weight"));
            //临时写入数据的方法
            try {
                //体重记录
                db.save(new WeightLog(1,1,56.2f));
                db.save(new WeightLog(2,2,56.3f));
                db.save(new WeightLog(3,3,56.4f));
                db.save(new WeightLog(4,4,56.2f));
                db.save(new WeightLog(5,5,56.5f));
                db.save(new WeightLog(6,6,56.3f));
                db.save(new WeightLog(7,7,56.5f));
            } catch (DbException e) {
                e.printStackTrace();
            }




            try {
                //图表一
                dataInit();
                //图表二
                dataInit2();
            } catch (DbException e) {
                e.printStackTrace();
            }
        }

        return view;
    }

    private void initView() {
        progress= (ArcProgress) view.findViewById(R.id.weight_progress);
        columnChart= (ColumnChartView) view.findViewById(R.id.home_tab);
        lineChartView= (LineChartView) view.findViewById(R.id.home_tab2);
        setp_progressBar= (ProgressBar) view.findViewById(R.id.setp_progressBar);
        setp_count= (TextView) view.findViewById(R.id.setp_count);
        weught_count= (TextView) view.findViewById(R.id.weught_count);
        food_count= (TextView) view.findViewById(R.id.food_count);
        home_welcome_imgs= (RelativeLayout) view.findViewById(R.id.home_welcome_imgs);
        textView= (TextView) view.findViewById(R.id.textView);
        progress.setMax(60);
        home_cardgroup= (NestedScrollView) view.findViewById(R.id.home_cardgroup);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnim(300);
            }
        });
        home_showPhoto= (ViewPager) getActivity().findViewById(R.id.home_showPhoto);
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

    private void dataInit() throws DbException {
        db=x.getDb(new DbManager.DaoConfig().setDbName("foodLog"));
        columnChart.setZoomEnabled(false);
        int numSubcolumns = 1;
        int numColumns = months.length;

        List<AxisValue> axisValues = new ArrayList<>();
        List<Column> columns = new ArrayList<>();
        List<SubcolumnValue> values;
        List<FoodLog> logList = db.selector(FoodLog.class).where(WhereBuilder.b("_id", "<=", "5").and("_id",">","0")).findAll();

        for (int i = 0; i <months.length; ++i) {

            values = new ArrayList<>();
            //设置数据
            values.add(new SubcolumnValue((float) logList.get(i).getFoodCount(),
                        ChartUtils.pickColor()));
// 点击柱状图就展示数据量
            axisValues.add(new AxisValue(i).setLabel(months[i]));
            columns.add(new Column(values).setHasLabels(false).setHasLabelsOnlyForSelected(false));
        }

        columnData = new ColumnChartData(columns);
        columnData.setAxisXBottom(new Axis(axisValues).setTextSize(8).setLineColor(Color.WHITE));
        columnData.setAxisYLeft(null);
        columnChart.setColumnChartData(columnData);
    }

    private void dataInit2() throws DbException {
        lineChartView.setZoomEnabled(false);
        db=x.getDb(new DbManager.DaoConfig().setDbName("weight"));
        List<Line> lines = new ArrayList<Line>();
        List<WeightLog> logList = db.selector(WeightLog.class).where(WhereBuilder.b("date", "<=", "7").and("date",">","0")).findAll();

        for (int i = 0; i <logList.size(); ++i) {

            List<PointValue> values = new ArrayList<>();
            //从数据库读取体重记录，改变体重记录表的数据
            values.add(new PointValue(0.1f,logList.get(0).getWeight()/10));
            values.add(new PointValue(0.2f,logList.get(1).getWeight()/10));
            values.add(new PointValue(0.3f,logList.get(2).getWeight()/10));
            values.add(new PointValue(0.4f,logList.get(3).getWeight()/10));
            values.add(new PointValue(0.5f,logList.get(4).getWeight()/10));
            values.add(new PointValue(0.6f,logList.get(5).getWeight()/10));
            values.add(new PointValue(0.7f,logList.get(6).getWeight()/10));
            //设置表的相关的属性
            Line line = new Line(values);
            line.setColor(ChartUtils.pickColor());
            line.setShape(ValueShape.CIRCLE);
            line.setCubic(false);
            line.setFilled(false);
            line.setHasLabels(false);
            line.setHasLabelsOnlyForSelected(false);
            line.setHasLines(true);
            line.setHasPoints(true);
            line.setPointRadius(3);
            line.setStrokeWidth(2);
            if (true) {
                line.setPointColor(ChartUtils.COLORS[(i + 1) % ChartUtils.COLORS.length]);
            }
            lines.add(line);
        }

        lineChartData = new LineChartData(lines);
        lineChartData.setAxisXBottom(null);
        lineChartData.setAxisYLeft(null);
        lineChartData.setBaseValue(Float.NaN);
        lineChartView.setLineChartData(lineChartData);
    }
}
