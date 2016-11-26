package com.boohee.boohee.View.Shop_View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.boohee.boohee.Bean.Shop_Bean.GoodsCarBean;
import com.boohee.boohee.R;
import com.boohee.boohee.Utils.Shop_Utils.SideslipListView;
import com.boohee.boohee.adapter.Shop_Adapter.GoodsCar_Adapter;
import com.boohee.boohee.presenter.Shop_Presenter.P_ShowGoodsCar_Impl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsCar_Activity extends AppCompatActivity {

    @BindView(R.id.GoodsAll_Pic)
    TextView GoodsAll_Pic;
    @BindView(R.id.GoodCar_ListView)
    ListView GoodCar_ListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_car_);
        ButterKnife.bind(this);
        P_ShowGoodsCar_Impl p_showGoodsCar = new P_ShowGoodsCar_Impl(new V_ShowGoodsCar() {
            @Override
            public void getData(List<GoodsCarBean> goodsCarBeanList) {
                GoodCar_ListView.setAdapter(new GoodsCar_Adapter(goodsCarBeanList,GoodsCar_Activity.this));
                Toast.makeText(GoodsCar_Activity.this, goodsCarBeanList.get(0).getGoodsnum()+"", Toast.LENGTH_SHORT).show();
            }
        });
        p_showGoodsCar.setData(3321);


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
