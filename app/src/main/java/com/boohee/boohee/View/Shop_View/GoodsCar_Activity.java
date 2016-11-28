package com.boohee.boohee.View.Shop_View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.boohee.boohee.Bean.shop_Bean.GoodsCarBean;
import com.boohee.boohee.Bean.shop_Bean.OrderEntity;
import com.boohee.boohee.R;
import com.boohee.boohee.Utils.Shop_Utils.PayResult;
import com.boohee.boohee.Utils.Shop_Utils.SideslipListView;
import com.boohee.boohee.View.MyApplication;
import com.boohee.boohee.adapter.Shop_Adapter.GoodsCar_Adapter;
import com.boohee.boohee.presenter.Shop_Presenter.AliPayPersenter;
import com.boohee.boohee.presenter.Shop_Presenter.AliPayPersenterImpl;
import com.boohee.boohee.presenter.Shop_Presenter.P_ShowGoodsCar_Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsCar_Activity extends AppCompatActivity {

    @BindView(R.id.GoodsCar_Loading)
    ProgressBar GoodsCar_Loading;
    @BindView(R.id.GoodsAll_Pic)
    TextView GoodsAll_Pic;
    @BindView(R.id.GoodCar_ListView)
    ListView GoodCar_ListView;
    int all_pic=0;

    private AliPayPersenter persenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_car_);
        ButterKnife.bind(this);
        P_ShowGoodsCar_Impl p_showGoodsCar = new P_ShowGoodsCar_Impl(new V_ShowGoodsCar() {
            @Override
            public void getData(List<GoodsCarBean> goodsCarBeanList) {
                GoodCar_ListView.setAdapter(new GoodsCar_Adapter(goodsCarBeanList,GoodsCar_Activity.this,GoodCar_ListView,GoodsAll_Pic));
                for (int i =0;i<goodsCarBeanList.size();i++){
                    all_pic +=(goodsCarBeanList.get(i).getGoodsnum())*(goodsCarBeanList.get(i).getGoodspic());
                }
                GoodsAll_Pic.setText(all_pic+"");
                GoodsCar_Loading.setVisibility(View.GONE);
            }
        });
        p_showGoodsCar.setData(MyApplication.userno,this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        GoodsCar_Loading.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.GoodsCar_Back)
    public void back(View v){
        finish();
    }

    @OnClick(R.id.GoodsCar_JiSuan)
    public void JiSuan(View v){
        persenter =new AliPayPersenterImpl(new Alipay_view() {
            @Override
            public void getDate(PayResult result) {
                String result1 = result.getResult();
                Toast.makeText(GoodsCar_Activity.this,result1.equals("")?"用户取消":result1,Toast.LENGTH_LONG).show();
            }
        } ,this);
        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);
        persenter.getData(new OrderEntity("所有商品",all_pic,key,"我的购物车"));
    }
}
