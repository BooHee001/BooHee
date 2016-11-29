package com.boohee.boohee.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.boohee.boohee.Bean.shop_Bean.FoodLog;
import com.boohee.boohee.Bean.shop_Bean.TypeBean;
import com.boohee.boohee.Bean.shop_Bean.WeightLog;
import com.boohee.boohee.R;
import com.boohee.boohee.View.HotLogActivity;
import com.boohee.boohee.View.MainActivity;
import com.boohee.boohee.View.WeightActivity;
import com.github.lzyzsd.circleprogress.ArcProgress;

import org.xutils.DbManager;
import org.xutils.common.util.KeyValue;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

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

public class LoseWeightFragment extends Fragment implements View.OnClickListener{
    private final static String[] months = new String[] { "早", "午", "晚",
            "加", "运动"};
    private View view;
    private NestedScrollView home_cardgroup;
    private ArcProgress progress;
    private TextView textView,textView5,home_daka;
    private ViewPager home_showPhoto;
    private int width;
    private int hight;
    private ImageView home_welcome_imgs,home_search,home_notification;
    private CardView home_zsdaka,home_hotlog,home_weightlog,home_steplog,home_weidulog;
    private LinearLayout home_myplan;
    private Bitmap bitmap=null;
    private View decorView;
    private DbManager db;
    private RelativeLayout home_r1;
    private LinearLayout home_r2;
    private ColumnChartView columnChart;
    private LineChartView lineChartView;
    private LineChartData lineChartData;
    //相关界面数据的更新，步数，体重记录，食物计数；
    private TextView setp_count,weught_count,food_count;
    //步数进度条
    private ProgressBar setp_progressBar;
    private ColumnChartData columnData;
    private LinearLayout card_layout;
    private boolean isUp=false;
    private boolean isDown=false;
    private static boolean isShow=false;
    private float lastY=0;
    private float lastX=0;
    private DbManager dbType=null;
    private Rect rect=null;
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
            dbType=x.getDb(new DbManager.DaoConfig().setDbName("type"));
            db=x.getDb(new DbManager.DaoConfig().setDbName("foodLog"));
            //临时写入数据的方法
            try {
                initPage();
                //临时写入数据的方法
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
                db.save(new WeightLog(1,"1",56.2f));
                db.save(new WeightLog(2,"2",56.3f));
                db.save(new WeightLog(3,"3",56.4f));
                db.save(new WeightLog(4,"4",56.2f));
                db.save(new WeightLog(5,"5",56.5f));
                db.save(new WeightLog(6,"6",56.3f));
                db.save(new WeightLog(7,"7",56.5f));
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

    private void initPage() throws DbException {
        TypeBean typeBean = dbType.selector(TypeBean.class).where(WhereBuilder.b("name", "=", "daka")).findFirst();
        if (typeBean!=null) {
            if (typeBean.isTrue()) {
                home_zsdaka.setVisibility(View.GONE);
            }else {
                home_zsdaka.setVisibility(View.VISIBLE);
            }
        }else {
            home_zsdaka.setVisibility(View.VISIBLE);
        }
        home_cardgroup.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                home_r1.setLayoutParams(new RelativeLayout.LayoutParams(width,(home_r1.getHeight() +scrollY/3-oldScrollY/3)));
            }
        });
        rect=new Rect(0,0,width,hight);
        home_cardgroup.setOnTouchListener(new View.OnTouchListener() {
            public float dX=0;
            public float dY=0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int action = event.getAction();
                float x = event.getX();
                float y = event.getY();
//                    LogUtils.out("ListView滑动","滑动"+event.getY());
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("测试,主页滑动","手指按下"+isUp);
                        lastY = y;
                        lastX = x;
                        isUp=false;
//                        return false;
                    case MotionEvent.ACTION_MOVE:
                        dY = Math.abs(y - lastY);
                        dX = Math.abs(x - lastX);
                        //Y大于lastY说明当前Y值大于按下时的Y值，即向下滑动的动作
                        boolean down = y > lastY ? true : false;
                        lastY = y;
                        lastX = x;
                        if((dX < 5 && dY >2)&&!down){
                            isUp=true;
//                            home_r1.setLayoutParams(new RelativeLayout.LayoutParams(width, (int) (home_r1.getHeight() - y + lastY)));
                            Log.d("测试,主页滑动","手指滑动向上"+isUp);
//                            home_r1.setLayoutParams(new RelativeLayout.LayoutParams(width, (int) (home_r1.getHeight()+dY)));
//                            setMarginTop((int) -home_r1.getHeight());
                        }
                        if((dX < 5 && dY >2)&&down){
                            isUp=false;

//                            home_welcome_imgs.setLayoutParams(new RelativeLayout.LayoutParams(width, (int) (home_r1.getHeight() +dY)));
//                            home_r2.setLayoutParams(new RelativeLayout.LayoutParams(width, (int) (home_r2.getHeight() +dY)));
                            textView5.setVisibility(View.VISIBLE);
                            textView5.setTextSize(dY/4);

                            if (dY>8&&isShow) {
                                setAnim(300);
                            }

                            Log.d("测试,主页滑动","手指滑动向下"+isUp);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("测试,主页滑动","手指抬起"+true);
                        textView5.setVisibility(View.INVISIBLE);
                        textView5.setTextSize(20);
                        boolean visibleRect = home_search.getLocalVisibleRect(rect);
                        if (visibleRect) {
                            isShow=true;
                        }else {
                            isShow=false;
                        }
//                        if (isUp) {
//                            setAnim(300);
//                        }
//                        home_welcome_imgs.setLayoutParams(new RelativeLayout.LayoutParams(width, (int) (home_r1.getHeight()-dY)));

                        break;
                    default:
                        break;
                }
                return false;
            }
        });




    }

    private void initView() {
        progress= (ArcProgress) view.findViewById(R.id.weight_progress);
        columnChart= (ColumnChartView) view.findViewById(R.id.home_tab);
        lineChartView= (LineChartView) view.findViewById(R.id.home_tab2);
        home_r1= (RelativeLayout) view.findViewById(R.id.home_r1);
        home_r2= (LinearLayout) view.findViewById(R.id.home_r2);
        setp_progressBar= (ProgressBar) view.findViewById(R.id.setp_progressBar);
        setp_count= (TextView) view.findViewById(R.id.setp_count);
        weught_count= (TextView) view.findViewById(R.id.weught_count);
        food_count= (TextView) view.findViewById(R.id.food_count);
        card_layout= (LinearLayout) view.findViewById(R.id.card_layout);
        home_welcome_imgs= (ImageView) view.findViewById(R.id.home_welcome_imgs);
        textView= (TextView) view.findViewById(R.id.textView);
        textView5= (TextView) view.findViewById(R.id.textView5);
        home_search = (ImageView) view.findViewById(R.id.home_search);
        home_notification = (ImageView) view.findViewById(R.id.home_notification);
        home_zsdaka = (CardView) view.findViewById(R.id.home_zsdaka);
        home_hotlog = (CardView) view.findViewById(R.id.home_hotlog);
        home_weightlog = (CardView) view.findViewById(R.id.home_weightlog);
        home_steplog = (CardView) view.findViewById(R.id.home_steplog);
        home_weidulog = (CardView) view.findViewById(R.id.home_weidulog);
        home_myplan = (LinearLayout) view.findViewById(R.id.home_myplan);
        progress.setMax(60);
        home_cardgroup= (NestedScrollView) view.findViewById(R.id.home_cardgroup);
        home_showPhoto= (ViewPager) getActivity().findViewById(R.id.home_showPhoto);
        home_daka = (TextView) view.findViewById(R.id.home_daka);
        textView.setOnClickListener(this);
        home_search.setOnClickListener(this);
        home_notification.setOnClickListener(this);
        home_daka.setOnClickListener(this);
        home_hotlog.setOnClickListener(this);
        home_weightlog.setOnClickListener(this);
        home_steplog.setOnClickListener(this);
        home_myplan.setOnClickListener(this);
        home_weidulog.setOnClickListener(this);
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
        MainActivity.isShow=true;
    }

    public void setWelcomeImgs(final String url){
       x.image().bind(home_welcome_imgs,url);
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


    @Override
    public void onClick(View view) {
        Intent intent=new Intent();
        switch (view.getId()) {
            //搜索
            case R.id.home_search:
                Toast.makeText(getActivity(),"搜索",Toast.LENGTH_SHORT).show();
                break;
            //通知消息
            case R.id.home_notification:
                Toast.makeText(getActivity(),"暂时没有消息",Toast.LENGTH_SHORT).show();
                break;
            //目标完成度
            case R.id.textView:
                break;
            //打卡
            case R.id.home_daka:
                db=x.getDb(new DbManager.DaoConfig().setDbName("type"));
                try {
                    db.saveOrUpdate(new TypeBean("daka",true));
                    Toast.makeText(getActivity(),"完成打卡",Toast.LENGTH_SHORT).show();
                    home_zsdaka.setVisibility(View.GONE);
                } catch (DbException e) {
                    Toast.makeText(getActivity(),"打卡失败",Toast.LENGTH_SHORT).show();
//                    e.printStackTrace();
                }
                break;
            //热量纪录
            case R.id.home_hotlog:
                intent.setClass(getActivity(), HotLogActivity.class) ;
                getActivity().startActivity(intent);
                break;
            //体重记录
            case R.id.home_weightlog:
                intent.setClass(getActivity(),WeightActivity.class);
                getActivity().startActivity(intent);
                break;
            //步数记录
            case R.id.home_steplog:
//                intent =  ;
//                getActivity().startActivity(intent);
                break;
            //我的计划
            case R.id.home_myplan:
//                intent =  ;
//                getActivity().startActivity(intent);
                break;
            //围度记录
            case R.id.home_weidulog:
//                intent =  ;
//                getActivity().startActivity(intent);
                break;
            default:
                break;
        }
    }
}
