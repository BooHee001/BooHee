package com.boohee.boohee.View;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.boohee.boohee.Bean.shop_Bean.WeightLog;
import com.boohee.boohee.R;
import com.boohee.boohee.Utils.Shop_Utils.CalendarView;

import org.xutils.DbManager;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeightActivity extends AppCompatActivity {
    @BindView(R.id.time)
    public LinearLayout layout;
    public CalendarView calendarView;
    private DbManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        ButterKnife.bind(this);
        db = x.getDb(new DbManager.DaoConfig().setDbName("weight"));
        calendarView = new CalendarView(this,db);
        layout.addView(calendarView);
//        this.overridePendingTransition(R.anim.in_to_right,R.anim.out_to_right);
        CalendarView.isTrue=true;
        calendarView.setOnCalendarViewListener(new CalendarView.OnCalendarViewListener() {
            @Override
            public void onCalendarItemClick(CalendarView view, Date date,int position,String iMonths) {
                Toast.makeText(WeightActivity.this,"点击位置"+position,Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(WeightActivity.this)
                            .create()
                            .show();
                    view.setMark(position, 34.9f);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        calendarView.initData();
    }

    @Override
    protected void onStop() {
        super.onStop();
        CalendarView.isTrue=false;
    }


    //    @Override
//    protected void onResume() {
//        super.onResume();
//
//    }
}
