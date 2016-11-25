package com.boohee.boohee.View.Shop_View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.boohee.boohee.R;
import com.boohee.boohee.fragment.ShopFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DingDan_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ding_dan_);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.GridView_Back)
    public void back(View v){
        finish();
    }
    @OnClick(R.id.GoodsCar_JiSuan)
    public void ToGoods(View v){
        Intent intent =new Intent(this, Shop_GridView_Activity.class);
        startActivity(intent);

    }
}
