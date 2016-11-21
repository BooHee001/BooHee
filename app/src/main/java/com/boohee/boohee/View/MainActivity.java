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
    private List<View> photoList = null;
    private float lastY = 0;
    private float lastX = 0;
    private static boolean isUp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hight = getWindowManager().getDefaultDisplay().getHeight();
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

        photoList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(R.drawable.a3d);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    setAnim();
                }
            });
            iv.setOnTouchListener(new View.OnTouchListener() {
                float oldX = 0;
                float oldY = 0;

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    final int action = event.getAction();
                    float x = event.getX();
                    float y = event.getY();
//                    LogUtils.out("ListView滑动","滑动"+event.getY());
                    switch (action) {
                        case MotionEvent.ACTION_DOWN:
                            Log.d("测试","手指按下"+isUp);
                            lastY = y;
                            lastX = x;
                            return false;
                        case MotionEvent.ACTION_MOVE:
                            float dY = Math.abs(y - lastY);
                            float dX = Math.abs(x - lastX);
                            //Y大于lastY说明当前Y值大于按下时的Y值，即向下滑动的动作
                            boolean down = y > lastY ? true : false;
                            lastY = y;
                            lastX = x;
                            if((dX < 5 && dY >5)&&!down){
                                isUp=true;
                                Log.d("测试","手指滑动向上"+isUp);
                            }
                            if((dX < 5 && dY >5)&&down){
                                isUp=false;
                                Log.d("测试","手指滑动向下"+isUp);
                            }


//                            if (isUp) {
//                                setAnim();
//                            }
                            break;
                        case MotionEvent.ACTION_UP:
                            Log.d("测试23","手指抬起"+isUp);
                            if (isUp) {
                                setAnim(300);
                            }
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
            photoList.add(iv);
        }
        adapter = new PhotoAdapter(photoList, this);
        home_showPhoto.setAdapter(adapter);
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
                    textViewList.get(lastChecked).setTextColor(Color.rgb(9, 9, 9));
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
                    textViewList.get(lastChecked).setTextColor(Color.rgb(9, 9, 9));
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
                    textViewList.get(lastChecked).setTextColor(Color.rgb(9, 9, 9));
                    textViewList.get(2).setTextColor(Color.rgb(41, 165, 82));

                    lastChecked = 2;
                }
                break;
            case R.id.MeLayout:
                if (lastChecked != 3) {
                    tabFragment(3);
                    imageViewList.get(lastChecked).setImageResource(imageList.get(lastChecked));
                    imageViewList.get(3).setImageResource(R.mipmap.a85);
                    textViewList.get(lastChecked).setTextColor(Color.rgb(9, 9, 9));
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
    public void loadData() {
//        photoList.addAll();
        adapter.notifyDataSetChanged();
    }


    private void setAnim(int duration) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(home_showPhoto, "translationY", 0, -hight);
        animator.setDuration(duration);
        animator.start();
    }
}
