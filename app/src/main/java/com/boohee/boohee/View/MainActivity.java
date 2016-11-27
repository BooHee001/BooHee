package com.boohee.boohee.View;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.boohee.boohee.PhotoBean.PhotoBean;
import com.boohee.boohee.R;
import com.boohee.boohee.adapter.PhotoAdapter;
import com.boohee.boohee.fragment.LoseWeightFragment;
import com.boohee.boohee.fragment.MeFragment;
import com.boohee.boohee.fragment.PartnerFragment;
import com.boohee.boohee.fragment.ShopFragment;
import com.boohee.boohee.presenter.Home_Persenter;
import com.boohee.boohee.presenter.Home_Presenter_impl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, HomePhoto {

    int currentfragmentIndex = 0;
    int lastChecked = 0;
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
    public ImageView partnerImage;
    @BindView(R.id.HuoBan_Text)
    public TextView partnerText;
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
    private PhotoAdapter adapter = null;
    private int hight = 0;
    private List<String> photoList = null;
    private LoseWeightFragment losFragment=null;
    public static boolean isShow=false;
    private boolean isExit=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                          | View.SYSTEM_UI_FLAG_VISIBLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION//隐藏状态栏的布局
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN//内容布局填满屏幕
        );
        setContentView(R.layout.activity_main);
        hight = getWindowManager().getDefaultDisplay().getHeight();
        losFragment=new LoseWeightFragment();
        ButterKnife.bind(this);
        initView();

        setListener();
        transaction.add(R.id.Main_View, fragmentList.get(0));
        transaction.commit();
    }

    //给主页下面四个图片设置点击监听事件
    private void setListener() {
        mainAddImg.setOnClickListener(this);
        loseweightLayout.setOnClickListener(this);
        partnerLayout.setOnClickListener(this);
        shopLayout.setOnClickListener(this);
        meLayout.setOnClickListener(this);

    }

    public void tabFragment(int fragmentIndex) {
        if (currentfragmentIndex != fragmentIndex) {
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            Fragment formFragment = fragmentList.get(currentfragmentIndex);
            Fragment toFragment = fragmentList.get(fragmentIndex);
            if (!toFragment.isAdded()) {
                transaction.hide(formFragment).add(R.id.Main_View, toFragment);
            } else {
                transaction.hide(formFragment).show(toFragment);
            }
//                transaction.addToBackStack(null);
            transaction.commit();
            currentfragmentIndex = fragmentIndex;
        }
    }


    private void initView() {

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        fragmentList = new ArrayList<>();
        fragmentList.add(losFragment);
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
        photoList = new ArrayList<>();
        adapter = new PhotoAdapter(photoList, MainActivity.this);
        home_showPhoto.setAdapter(adapter);
        Home_Persenter persenter=new Home_Presenter_impl(this);
        persenter.getData();
        setAnim(1);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loseWeightLayout: {
                if (lastChecked != 0) {
                    tabFragment(0);
                    imageViewList.get(lastChecked).setImageResource(imageList.get(lastChecked));
                    imageViewList.get(0).setImageResource(R.mipmap.a83);
                    textViewList.get(lastChecked).setTextColor(Color.rgb(153, 153, 153));
                    textViewList.get(0).setTextColor(Color.rgb(41, 165, 82));
                    lastChecked = 0;
                }

            }
            break;
            case R.id.PartnerLayout:
                if (lastChecked != 1) {
                    tabFragment(1);
                    imageViewList.get(lastChecked).setImageResource(imageList.get(lastChecked));
                    imageViewList.get(1).setImageResource(R.mipmap.a81);
                    textViewList.get(lastChecked).setTextColor(Color.rgb(153, 153, 153));
                    textViewList.get(1).setTextColor(Color.rgb(41, 165, 82));
                    lastChecked = 1;
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
                if (lastChecked != 2) {
                    tabFragment(2);
                    imageViewList.get(lastChecked).setImageResource(imageList.get(lastChecked));
                    imageViewList.get(2).setImageResource(R.mipmap.a87);
                    textViewList.get(lastChecked).setTextColor(Color.rgb(153, 153, 153));
                    textViewList.get(2).setTextColor(Color.rgb(41, 165, 82));

                    lastChecked = 2;
                }
                break;
            case R.id.MeLayout:
                if (lastChecked != 3) {
                    tabFragment(3);
                    imageViewList.get(lastChecked).setImageResource(imageList.get(lastChecked));
                    imageViewList.get(3).setImageResource(R.mipmap.a85);
                    textViewList.get(lastChecked).setTextColor(Color.rgb(153, 153, 153));
                    textViewList.get(3).setTextColor(Color.rgb(41, 165, 82));
                    lastChecked = 3;
                }
                break;
//            case R.id.home_showPhoto:
//                setAnim();
//                break;
        }
    }


    @Override
    public void loadData(PhotoBean data) {
//        photoList.addAll();
        List<PhotoBean.WelcomeImgBean.WeekImagesBean> week_images = data.getWelcome_img().getWeek_images();
        for (PhotoBean.WelcomeImgBean.WeekImagesBean week_image : week_images) {
            photoList.add(week_image.getBack_img());
        }
        losFragment.setWelcomeImgs(data.getWelcome_img().getBack_img_small());
        adapter.notifyDataSetChanged();
        home_showPhoto.setCurrentItem(photoList.size()-1);
    }


    private void setAnim(int duration) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(home_showPhoto, "translationY", 0, -hight);
        animator.setDuration(duration);
        animator.start();
        isShow=false;
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1://处理返回键时间
                    isExit=false;
                    break;
            }
        }
    };
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isShow) {
                setAnim(300);
            }else if (isExit) {
                //                new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("退出")
//                        .setMessage("确定要退出么？")
//                        .setNegativeButton("取消",null)
//                        .setPositiveButton("退出", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                finish();
//                            }
//                        })
//                        .create()
//                        .show();
                finish();
            }else{
                Toast.makeText(MainActivity.this,"你还想退出？再按一次试试看",Toast.LENGTH_SHORT).show();
                isExit=true;
                handler.sendEmptyMessageDelayed(1,1000);
            }


            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
