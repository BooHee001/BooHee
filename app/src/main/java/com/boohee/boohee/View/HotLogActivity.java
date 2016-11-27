package com.boohee.boohee.View;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.boohee.boohee.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotLogActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.hot_time)
    public TextView hot_time;
    @BindView(R.id.hot_back)
    public ImageView hot_back;
    @BindView(R.id.hot_time_jia)
    public ImageView hot_time_jia;
    @BindView(R.id.hot_time_jian)
    public ImageView hot_time_jian;
    @BindView(R.id.hot_menu)
    public ImageView hot_menu;
    @BindView(R.id.hot_weidabiao)
    public LinearLayout hot_weidabiao;
    @BindView(R.id.hot_sheru)
    public TextView hot_sheru;
    @BindView(R.id.hot_yundong)
    public TextView hot_yundong;
    @BindView(R.id.hot_qianka)
    public TextView hot_qianka;
    @BindView(R.id.hot_loglist)
    public ListView hot_loglist;
    @BindView(R.id.hot_loglist_empty)
    public LinearLayout hot_loglist_empty;
    @BindView(R.id.hot_addzao)
    public LinearLayout hot_addzao;
    @BindView(R.id.hot_addwu)
    public LinearLayout hot_addwu;
    @BindView(R.id.hot_addwan)
    public LinearLayout hot_addwan;
    @BindView(R.id.hot_addjia)
    public LinearLayout hot_addjia;
    @BindView(R.id.hot_addyun)
    public LinearLayout hot_addyun;
    private AlertDialog dateDialog=null;
    private CardView date_goteday=null;
    private CalendarView date=null;
    private LinearLayout layout=null;
    private static String dateNow=null;
    private static int date_1=0;
    private static int date_2=0;
    private static int date_3=0;
    private Date dat=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_log);
        ButterKnife.bind(this);
        initData();
        setListener();
    }

    private void setListener() {
        hot_back.setOnClickListener(this);
        hot_addzao.setOnClickListener(this);
        hot_addwu.setOnClickListener(this);
        hot_addwan.setOnClickListener(this);
        hot_addjia.setOnClickListener(this);
        hot_addyun.setOnClickListener(this);
        hot_menu.setOnClickListener(this);
        hot_time.setOnClickListener(this);
        hot_time_jia.setOnClickListener(this);
        hot_time_jian.setOnClickListener(this);
        date.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                date_1=i;
                date_2=i1;
                date_3=i2;
                hot_time.setText(date_1+"-"+date_2+"-"+date_3);
            }
        });
//        dateDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//            @Override
//            public void onCancel(DialogInterface dialogInterface) {
//
//            }
//        });
    }

    private void initData() {
        layout= (LinearLayout) LayoutInflater.from(this).inflate(R.layout.dateview,null);
        dateDialog = new AlertDialog.Builder(HotLogActivity.this)
                .setView(layout)
                .create();
        date_goteday = (CardView) layout.findViewById(R.id.date_goteday);
        date = (CalendarView) layout.findViewById(R.id.date);
        date.setDate(new Date().getTime(),true,true);
        date_goteday.setOnClickListener(this);
        date.setOnClickListener(this);
        hot_time.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        //摄入量
        hot_sheru.setText("120");
        //还可以吃/千卡
        hot_qianka.setText("1203");
        //运动量
        hot_yundong.setText("123");
    }
    @Override
    public void onClick(View view) {
        Intent intent=new Intent();
        switch (view.getId()) {
            //月份显示
            case R.id.hot_time:
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
                try {
                    dat = format.parse(hot_time.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                date.setDate(dat.getTime());
                dateDialog.show();
                Window window = dateDialog.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width=getWindowManager().getDefaultDisplay().getWidth();
                attributes.height=getWindowManager().getDefaultDisplay().getHeight()-300;
                attributes.horizontalMargin=100;
                attributes.gravity= Gravity.TOP;
                window.setAttributes(attributes);
                break;
            //返回键
            case R.id.hot_back:
                finish();
                break;
            //月份加
            case R.id.hot_time_jia:
                date_3=date_3+1;
                hot_time.setText(date_1+"-"+date_2+"-"+date_3);
                break;
            //月份减
            case R.id.hot_time_jian:
                date_3=date_3-1;
                hot_time.setText(date_1+"-"+date_2+"-"+date_3);
                break;
            //更多菜单
            case R.id.hot_menu:
                break;
            //添加早餐
            case R.id.hot_addzao:
                Toast.makeText(HotLogActivity.this,"未联网，不能添加计划",Toast.LENGTH_SHORT).show();
                break;
            //添加午餐
            case R.id.hot_addwu:
                Toast.makeText(HotLogActivity.this,"未联网，不能添加计划",Toast.LENGTH_SHORT).show();
                break;
            //添加晚餐
            case R.id.hot_addwan:
                Toast.makeText(HotLogActivity.this,"未联网，不能添加计划",Toast.LENGTH_SHORT).show();
                break;
            //添加加餐
            case R.id.hot_addjia:
                Toast.makeText(HotLogActivity.this,"未联网，不能添加计划",Toast.LENGTH_SHORT).show();
                break;
            //添加运动
            case R.id.hot_addyun:
                Toast.makeText(HotLogActivity.this,"未联网，不能添加计划",Toast.LENGTH_SHORT).show();
                break;
            //摄入量未达标
            case R.id.hot_weidabiao:
//                intent=
//                startActivity(intent);
                break;
            //日历选择回到今日
            case R.id.date_goteday:
                date.setDate(new Date().getTime(),true,true);
                hot_time.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                break;
            default:
                break;
        }
    }
}
