package com.boohee.boohee.View.Shop_View;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.boohee.boohee.Bean.shop_Bean.GoodsCarBean;
import com.boohee.boohee.Bean.shop_Bean.OrderEntity;
import com.boohee.boohee.Bean.shop_Bean.Shop_GoodsInfo_Bean;
import com.boohee.boohee.R;
import com.boohee.boohee.Utils.Shop_Utils.BadgeView;
import com.boohee.boohee.Utils.Shop_Utils.PayResult;
import com.boohee.boohee.View.MyApplication;
import com.boohee.boohee.adapter.Shop_Adapter.Shop_Details_ViewPagerAdapter;
import com.boohee.boohee.fragment.ShopFragments.Shop_Details_AssessFragment;
import com.boohee.boohee.fragment.ShopFragments.Shop_Details_GoodsFragment;
import com.boohee.boohee.presenter.Shop_Presenter.AliPayPersenter;
import com.boohee.boohee.presenter.Shop_Presenter.AliPayPersenterImpl;
import com.boohee.boohee.presenter.Shop_Presenter.P_AddGoodsCar_Impl;
import com.boohee.boohee.presenter.Shop_Presenter.P_Shop_GoodsInfo_Impl;
import com.boohee.boohee.presenter.Shop_Presenter.P_ShowGoodsCarForImg_Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Shop_Details_Activity extends AppCompatActivity implements View.OnClickListener {

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
    CardView Details_ShoppingCar;
    @BindView(R.id.Details_KeFu)
    CardView Details_KeFu;
    @BindView(R.id.Details_By)
    CardView Details_By;
    @BindView(R.id.Add_ShoppingCar)
    CardView add_ShoppingCar;
    @BindView(R.id.Details_Badge)
    BadgeView Details_Badge;
    private List<Fragment> fragmentList;
    private List<TextView> textViewList;
    private List<View> viewList;

    private Intent intent;
    private String goodsname;
    private String goodsimg;
    private String goodspic;
    private double aLong;


    private int lastPosition = 0;
    private int goodsNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop__details);
        ButterKnife.bind(this);
        initView();
        initData();
        details_ViewPager.setAdapter(new Shop_Details_ViewPagerAdapter(getSupportFragmentManager(), fragmentList));
        setListener();

        //获取id并将id传递给fragment
        Bundle bundle = new Bundle();
        bundle.putInt("id", getIntent().getIntExtra("id", -1));
        fragmentList.get(0).setArguments(bundle);
        fragmentList.get(1).setArguments(bundle);
        if (goodsNum == 0) {
            Details_Badge.hide();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {

                //设置购物车的上的小图标
                final P_ShowGoodsCarForImg_Impl p_showGoodsCarForImg_ = new P_ShowGoodsCarForImg_Impl(new V_ShowGoodsCarForImg() {
                    @Override
                    public void setData(GoodsCarBean goodsCarBean) {
                        goodsNum = goodsCarBean.getGoodsnum();
                        if (goodsNum > 0) {
                            Details_Badge.setVisibility(View.VISIBLE);
                            Details_Badge.setText(goodsNum + "");
                        }
                    }
                });
                p_showGoodsCarForImg_.getData(MyApplication.userno, goodsimg, Shop_Details_Activity.this);

            }
        }).start();
    }

    private void initData() {

        intent = getIntent();
        goodsname = intent.getStringExtra("goodsname");
        goodsimg = intent.getStringExtra("goodsimg");
        goodspic = intent.getStringExtra("goodspic");
        if(goodspic !=null) {
            aLong = Double.parseDouble(goodspic);
        }
    }

    //事件监听
    private void setListener() {
        details_ViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (lastPosition != position) {
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

        //获取传来的数据并进行显示
        shop_Details_Title.setText(getIntent().getStringExtra("title"));

        new Thread(new Runnable() {
            @Override
            public void run() {
                P_Shop_GoodsInfo_Impl p_shop_goodsInfo = new P_Shop_GoodsInfo_Impl(new V_Shop_GoodsInfo() {
                    @Override
                    public void setData(Shop_GoodsInfo_Bean shop_goodsInfo_bean) {
                        goodsname = shop_goodsInfo_bean.getGoods().getCategory_name();
                        goodsimg = shop_goodsInfo_bean.getGoods().getBig_photo_url();
                        aLong = shop_goodsInfo_bean.getGoods().getMarket_price();
                    }
                });
                p_shop_goodsInfo.initData(getIntent().getIntExtra("id", -1));


            }
        }).start();
    }

    //返回键的点击事件
    @OnClick(R.id.shop_Details_Back)
    public void back(View v) {
        finish();
    }

    //分享的点击事件
    @OnClick(R.id.shop_Details_FenXiang)
    public void shop_Details_FenXiang(View V) {

    }

    //立即购买
    @OnClick(R.id.Details_By)
    public void play(View V) {
        AliPayPersenter persenter = new AliPayPersenterImpl(new Alipay_view() {
            @Override
            public void getDate(PayResult result) {
                String result1 = result.getResult();
                Toast.makeText(Shop_Details_Activity.this, result1.equals("") ? "用户取消" : result1, Toast.LENGTH_LONG).show();
            }
        }, this);
        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);
        persenter.getData(new OrderEntity(goodsname, ((float) aLong * goodsNum), key, "我的购物车"));
    }

    //添加购物车的点击事件
    @OnClick(R.id.Add_ShoppingCar)
    public void add(View v) {
        if (goodsNum == 0) {
            Details_Badge.setVisibility(View.VISIBLE);
            Details_Badge.setText(1 + "");
        }
        Toast.makeText(Shop_Details_Activity.this, "添加成功", Toast.LENGTH_SHORT).show();
        goodsNum++;
        if (goodsNum > 0) {
            Details_Badge.setVisibility(View.VISIBLE);
            Details_Badge.setText(goodsNum + "");
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                P_AddGoodsCar_Impl p_addGoodsCar = new P_AddGoodsCar_Impl(new V_AddGoodsCar() {
                    @Override
                    public void getResult(String result) {

                    }
                });

                p_addGoodsCar.initData(MyApplication.userno, goodsname, goodsimg, (int) aLong, goodsNum);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                P_ShowGoodsCarForImg_Impl p_showGoodsCarForImg_ = new P_ShowGoodsCarForImg_Impl(new V_ShowGoodsCarForImg() {
                    @Override
                    public void setData(GoodsCarBean goodsCarBean) {
                        if (goodsNum > 0) {
                            Details_Badge.setVisibility(View.VISIBLE);
                            Details_Badge.setText(goodsNum + "");
                        }
                    }
                });
                p_showGoodsCarForImg_.getData(MyApplication.userno, goodsimg, Shop_Details_Activity.this);
            }
        }).start();


    }

    //从购物车图标跳转到购物车
    @OnClick(R.id.Details_ShoppingCar)
    public void goToGoodsCar(View v) {
        intent = new Intent(this, GoodsCar_Activity.class);
        startActivity(intent);

    }

    //viewpager中的点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Details_Goods:
                details_ViewPager.setCurrentItem(0);
                break;
            case R.id.Details_Assess:
                details_ViewPager.setCurrentItem(1);
                break;
        }
    }
}
