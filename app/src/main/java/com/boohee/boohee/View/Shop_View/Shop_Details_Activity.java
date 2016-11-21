package com.boohee.boohee.View.Shop_View;

import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.boohee.boohee.R;
import com.boohee.boohee.Utils.Shop_Utils.BadgeView;
import com.boohee.boohee.adapter.Shop_Adapter.Shop_Details_ViewPagerAdapter;
import com.boohee.boohee.fragment.ShopFragments.Shop_Details_AssessFragment;
import com.boohee.boohee.fragment.ShopFragments.Shop_Details_GoodsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Shop_Details_Activity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.Details_ViewPager)
    ViewPager details_ViewPager;

    @BindView(R.id.Details_AssessView)
    View details_AssessView;
    @BindView(R.id.Details_Assess)
    TextView details_Assess;
    @BindView(R.id.Details_GoodsView)
    View details_GoodsView;
    @BindView(R.id.Details_Goods)
    TextView details_Goods;

    @BindView(R.id.shop_Details_Title)
    TextView shop_Details_Title;
    @BindView(R.id.Details_ShoppingCar)
    View Details_ShoppingCar;
    @BindView(R.id.Details_KeFu)
    View Details_KeFu;
    @BindView(R.id.Details_By)
    TextView Details_By;
    @BindView(R.id.Add_ShoppingCar)
    TextView add_ShoppingCar;
    @BindView(R.id.Details_Badge)
    BadgeView Details_Badge;
    private List<Fragment> fragmentList;
    private List<TextView> textViewList;
    private List<View> viewList;

    private int lastPosition =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop__details);
        ButterKnife.bind(this);
        initView();
        details_ViewPager.setAdapter(new Shop_Details_ViewPagerAdapter(getSupportFragmentManager(),fragmentList));
        setListener();
    }

    //事件监听
    private void setListener() {
        details_ViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
               if(lastPosition !=position) {
                   textViewList.get(position).setTextColor(Color.rgb(41, 165, 82));
                   viewList.get(position).setBackgroundColor(Color.rgb(41, 165, 82));

                   viewList.get(lastPosition).setBackgroundColor(Color.rgb(229, 228, 230));
                   textViewList.get(lastPosition).setTextColor(Color.rgb(0, 0, 0));

                   lastPosition = position;
               }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        details_Goods.setOnClickListener(this);
        details_Assess.setOnClickListener(this);
    }

    //进行数据的初始化
    private void initView() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new Shop_Details_GoodsFragment());
        fragmentList.add(new Shop_Details_AssessFragment());

        textViewList = new ArrayList<>();
        textViewList.add(details_Goods);
        textViewList.add(details_Assess);

        viewList = new ArrayList<>();
        viewList.add(details_GoodsView);
        viewList.add(details_AssessView);
    }

    //返回键的点击事件
    @OnClick(R.id.shop_Details_Back)
    public void back(View v){
        finish();
    }
    //分享的点击事件
    @OnClick(R.id.shop_Details_FenXiang)
    public void shop_Details_FenXiang(View V){

    }

    //添加购物车的点击事件
    @OnClick(R.id.Add_ShoppingCar)
    public void add(View v){

    }
   //viewpager中的点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Details_Goods :
                details_ViewPager.setCurrentItem(0);
                break;
            case R.id.Details_Assess :
                details_ViewPager.setCurrentItem(1);
                break;
        }
    }
}
