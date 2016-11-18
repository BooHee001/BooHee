package com.boohee.boohee.View;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.boohee.boohee.R;
import com.boohee.boohee.fragment.LoseWeightFragment;
import com.boohee.boohee.fragment.MeFragment;
import com.boohee.boohee.fragment.MenuFragment;
import com.boohee.boohee.fragment.PartnerFragment;
import com.boohee.boohee.fragment.ShopFragment;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    //中间添加
    @ViewInject(R.id.Main_AddImg)
    private ImageView mainAddImg;
    //减肥
    @ViewInject(R.id.JianFei_Img)
    private ImageView reduceweightImage;
    @ViewInject(R.id.JianFei_Text)
    private TextView reduceweightText;

    //伙伴
    @ViewInject(R.id.HuoBan_Img)
    private ImageView  partnerImage;
    @ViewInject(R.id.HuoBan_Text)
    private TextView  partnerText;

    //商店
    @ViewInject(R.id.Shop_Img)
    private ImageView shopImage;
    @ViewInject(R.id.Shop_Text)
    private TextView shopText;

    //我
    @ViewInject(R.id.Me_Img)
    private ImageView meImage;
    @ViewInject(R.id.Me_Text)
    private TextView meText;

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

    int currentfragmentIndex =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        initView();
        setListener();
    }

    //给主页下面四个图片设置点击监听事件
    private void setListener() {
        mainAddImg.setOnClickListener(this);
        reduceweightImage.setOnClickListener(this);
        partnerImage.setOnClickListener(this);
        shopImage.setOnClickListener(this);
        meImage.setOnClickListener(this);

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
        fragmentList = new ArrayList<>();
        fragmentList.add(new LoseWeightFragment());
        fragmentList.add(new PartnerFragment());
        fragmentList.add(new ShopFragment());
        fragmentList.add(new MeFragment());

        imageViewList = new ArrayList<>();
        imageViewList.add(reduceweightImage);
        imageViewList.add(partnerImage);
        imageViewList.add(shopImage);
        imageViewList.add(meImage);

        imageList = new ArrayList<>();
        imageList.add(R.mipmap.a82);
        imageList.add(R.mipmap.a80);
        imageList.add(R.mipmap.a86);
        imageList.add(R.mipmap.a84);

        textViewList = new ArrayList<>();
        textViewList.add(reduceweightText);
        textViewList.add(partnerText);
        textViewList.add(shopText);
        textViewList.add(meText);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.JianFei_Img:{
                tabFragment(0);
                    imageViewList.get(currentfragmentIndex).setBackgroundResource(imageList.get(currentfragmentIndex));
                    imageViewList.get(0).setBackgroundResource(R.mipmap.a83);
                    textViewList.get(currentfragmentIndex).setTextColor(Color.rgb(9,9,9));
                    textViewList.get(0).setTextColor(Color.rgb(41,165,82));

            }
                break;
            case R.id.HuoBan_Img:
                tabFragment(1);
                    imageViewList.get(currentfragmentIndex).setBackgroundResource(imageList.get(currentfragmentIndex));
                    imageViewList.get(1).setBackgroundResource(R.mipmap.a81);
                    textViewList.get(currentfragmentIndex).setTextColor(Color.rgb(9,9,9));
                    textViewList.get(1).setTextColor(Color.rgb(41,165,82));
                break;
            case R.id.Main_AddImg:
//                tabFragment(2);
//                if (currentfragmentIndex != 0) {
//                    imageViewList.get(currentfragmentIndex).setBackgroundResource(imageList.get(currentfragmentIndex));
//                    imageViewList.get(0).setBackgroundResource(R.mipmap.a4l);
//                }
                break;
            case R.id.Shop_Img:
                tabFragment(2);
                    imageViewList.get(currentfragmentIndex).setBackgroundResource(imageList.get(currentfragmentIndex));
                    imageViewList.get(2).setBackgroundResource(R.mipmap.a87);
                    textViewList.get(currentfragmentIndex).setTextColor(Color.rgb(9,9,9));
                    textViewList.get(2).setTextColor(Color.rgb(41,165,82));
                break;
            case R.id.Me_Img:
                tabFragment(3);
                    imageViewList.get(currentfragmentIndex).setBackgroundResource(imageList.get(currentfragmentIndex));
                    imageViewList.get(3).setBackgroundResource(R.mipmap.a85);
                    textViewList.get(currentfragmentIndex).setTextColor(Color.rgb(9,9,9));
                    textViewList.get(3).setTextColor(Color.rgb(41,165,82));
                break;
        }
    }
}
