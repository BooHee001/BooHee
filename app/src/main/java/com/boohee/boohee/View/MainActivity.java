package com.boohee.boohee.View;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.boohee.boohee.R;
import com.boohee.boohee.adapter.PhotoAdapter;
import com.boohee.boohee.fragment.LoseWeightFragment;
import com.boohee.boohee.fragment.MeFragment;
import com.boohee.boohee.fragment.PartnerFragment;
import com.boohee.boohee.fragment.ShopFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener,HomePhoto{

    int currentfragmentIndex = 0;
    int lastChecked =0;
    @BindView(R.id.loseWeightLayout)
    public LinearLayout loseweightLayout;
    @BindView(R.id.MeLayout)
    public LinearLayout meLayout;
    @BindView(R.id.PartnerLayout)
    public LinearLayout partnerLayout;
    @BindView(R.id.ShopLayout)
    public LinearLayout shopLayout;
    //中间添加
    @BindView(R.id.Main_AddImg)
    public ImageView mainAddImg;
    //减肥
    @BindView(R.id.JianFei_Img)
    public ImageView loseweightImage;
    @BindView(R.id.JianFei_Text)
    public TextView loseweightText;
    //伙伴
    @BindView(R.id.HuoBan_Img)
    public ImageView  partnerImage;
    @BindView(R.id.HuoBan_Text)
    public TextView  partnerText;
    //商店
    @BindView(R.id.Shop_Img)
    public ImageView shopImage;
    @BindView(R.id.Shop_Text)
    public TextView shopText;
    //我
    @BindView(R.id.Me_Img)
    public ImageView meImage;
    @BindView(R.id.Me_Text)
    public TextView meText;
    private FragmentManager manager;
    //存放fragment的集合
    private List<Fragment> fragmentList;
    //用来存放ImageVIew组件的集合
    private List<ImageView> imageViewList;
    //用来存放TextView组件的集合
    private List<TextView> textViewList;
    //用来存放TextView组件的集合
    private List<Integer> imageList;
    private FragmentTransaction transaction;
    //首页下滑的ViewPager；需要覆盖全屏，所以放在MainActivity中操作；
    @BindView(R.id.home_showPhoto)
    public ViewPager home_showPhoto;
    private PhotoAdapter adapter=null;
    private int hight=0;
    private List<View> photoList=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        setListener();
        transaction.add(R.id.Main_View,fragmentList.get(0));
        transaction.commit();
        hight=getWindowManager().getDefaultDisplay().getHeight();
    }

    //给主页下面四个图片设置点击监听事件
    private void setListener() {
        mainAddImg.setOnClickListener(this);
        loseweightLayout.setOnClickListener(this);
        partnerLayout.setOnClickListener(this);
        shopLayout.setOnClickListener(this);
        meLayout.setOnClickListener(this);
        home_showPhoto.setOnTouchListener(new View.OnTouchListener() {
            public float y=0;
            public float x=0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = v.getX();
                        y = v.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d("滑动","滑动");
                        float newX = v.getX();
                        float newY = v.getY();
                        if ((Math.abs(newX-x)<10) && (Math.abs(newY-y)>15)) {
                            setAnim();
                        }

                        break;
                }
                return false;
            }
        });
//        new Home_Presenter_impl(this).getData();


    }

    public void tabFragment(int fragmentIndex){
        if(currentfragmentIndex!=fragmentIndex){
            manager=getSupportFragmentManager();
            transaction=manager.beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            Fragment formFragment=fragmentList.get(currentfragmentIndex);
            Fragment toFragment=fragmentList.get(fragmentIndex);
            if(!toFragment.isAdded()){
                transaction.hide(formFragment).add(R.id.Main_View,toFragment);
            }else{
                transaction.hide(formFragment).show(toFragment);
            }
//                transaction.addToBackStack(null);
            transaction.commit();
            currentfragmentIndex=fragmentIndex;
        }
    }


    private void initView() {

        manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();

        fragmentList = new ArrayList<>();
        fragmentList.add(new LoseWeightFragment());
        fragmentList.add(new PartnerFragment());
        fragmentList.add(new ShopFragment());
        fragmentList.add(new MeFragment());

        imageViewList = new ArrayList<>();
        imageViewList.add(loseweightImage);
        imageViewList.add(partnerImage);
        imageViewList.add(shopImage);
        imageViewList.add(meImage);

        imageList = new ArrayList<>();
        imageList.add(R.mipmap.a82);
        imageList.add(R.mipmap.a80);
        imageList.add(R.mipmap.a86);
        imageList.add(R.mipmap.a84);

        textViewList = new ArrayList<>();
        textViewList.add(loseweightText);
        textViewList.add(partnerText);
        textViewList.add(shopText);
        textViewList.add(meText);

        photoList=new ArrayList<>();
        adapter=new PhotoAdapter(photoList,this);
        home_showPhoto.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loseWeightLayout:{
                if(lastChecked !=0) {
                    tabFragment(0);
                    imageViewList.get(lastChecked).setImageResource(imageList.get(lastChecked));
                    imageViewList.get(0).setImageResource(R.mipmap.a83);
                    textViewList.get(lastChecked).setTextColor(Color.rgb(9, 9, 9));
                    textViewList.get(0).setTextColor(Color.rgb(41, 165, 82));
                    lastChecked =0;
                }

            }
                break;
            case R.id.PartnerLayout:
                if(lastChecked !=1) {
                    tabFragment(1);
                    imageViewList.get(lastChecked).setImageResource(imageList.get(lastChecked));
                    imageViewList.get(1).setImageResource(R.mipmap.a81);
                    textViewList.get(lastChecked).setTextColor(Color.rgb(9, 9, 9));
                    textViewList.get(1).setTextColor(Color.rgb(41, 165, 82));
                    lastChecked =1;
                }
                break;
            case R.id.Main_AddImg:
//                tabFragment(2);
//                if (currentfragmentIndex != 0) {
//                    imageViewList.get(currentfragmentIndex).setBackgroundResource(imageList.get(currentfragmentIndex));
//                    imageViewList.get(0).setBackgroundResource(R.mipmap.a4l);
//                }
                break;
            case R.id.ShopLayout:
                if(lastChecked !=2) {
                    tabFragment(2);
                    imageViewList.get(lastChecked).setImageResource(imageList.get(lastChecked));
                    imageViewList.get(2).setImageResource(R.mipmap.a87);
                    textViewList.get(lastChecked).setTextColor(Color.rgb(9, 9, 9));
                    textViewList.get(2).setTextColor(Color.rgb(41, 165, 82));

                    lastChecked =2;
                }
                break;
            case R.id.MeLayout:
                if(lastChecked !=3) {
                    tabFragment(3);
                    imageViewList.get(lastChecked).setImageResource(imageList.get(lastChecked));
                    imageViewList.get(3).setImageResource(R.mipmap.a85);
                    textViewList.get(lastChecked).setTextColor(Color.rgb(9, 9, 9));
                    textViewList.get(3).setTextColor(Color.rgb(41, 165, 82));

                    lastChecked =3;
                }
                break;
//            case R.id.home_showPhoto:
//                setAnim();
//                break;
        }
    }


    @Override
    public void loadData() {
//        photoList.addAll();
        adapter.notifyDataSetChanged();
    }


    private void setAnim() {
        ObjectAnimator animator=ObjectAnimator.ofFloat(home_showPhoto,"translationY",0,-hight);
        animator.setDuration(500);
        animator.start();
    }
}
