package com.boohee.boohee.View.Shop_View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.boohee.boohee.R;
import com.boohee.boohee.Utils.Shop_Utils.SideslipListView;
import com.boohee.boohee.adapter.Shop_Adapter.GoodsCar_Adapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsCar_Activity extends AppCompatActivity {

    @BindView(R.id.GoodsAll_Pic)
    TextView GoodsAll_Pic;
    @BindView(R.id.GoodCar_ListView)
    SideslipListView GoodCar_ListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_car_);
        ButterKnife.bind(this);

        List list = new ArrayList();
        for(int i =0;i<30;i++){
            list.add(list);
        }

        GoodCar_ListView.setAdapter(new GoodsCar_Adapter(list,this,GoodCar_ListView));
    }
    @OnClick(R.id.GoodsCar_Back)
    public void back(View v){
        finish();
    }

    @OnClick(R.id.GoodsCar_JiSuan)
    public void JiSuan(View v){
        Toast.makeText(this, "结算", Toast.LENGTH_SHORT).show();
    }
}
