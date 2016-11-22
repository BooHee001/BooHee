package com.boohee.boohee.fragment;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boohee.boohee.R;
import com.bumptech.glide.Glide;
import com.github.lzyzsd.circleprogress.ArcProgress;

import java.util.concurrent.ExecutionException;

/**
 * Created by Dizner on 2016/11/18.
 */

public class LoseWeightFragment extends Fragment {
    private View view;
    private NestedScrollView home_cardgroup;
    private ArcProgress progress;
    private TextView textView;
    private int i=20;
    private ViewPager home_showPhoto;
    private PagerAdapter adapter;
    private int width;
    private int hight;

    private RelativeLayout home_welcome_imgs;
    private Bitmap bitmap=null;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.loseweight_fragment, container, false);
            progress= (ArcProgress) view.findViewById(R.id.weight_progress);
            home_welcome_imgs= (RelativeLayout) view.findViewById(R.id.home_welcome_imgs);
            textView= (TextView) view.findViewById(R.id.textView);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i>0) {
                        i-=1;
                        setAnim(300);
                    }
                }
            });
            home_showPhoto= (ViewPager) getActivity().findViewById(R.id.home_showPhoto);
            width=getActivity(). getWindowManager().getDefaultDisplay().getWidth();
            hight=getActivity(). getWindowManager().getDefaultDisplay().getHeight();
//            home_showPhoto.setLayoutParams(new CoordinatorLayout.LayoutParams(width,hight));
            progress.setMax(60);;
            home_cardgroup= (NestedScrollView) view.findViewById(R.id.home_cardgroup);
//            setAnim();

        }

        return view;
    }
    private void setAnim(int duration) {
        ObjectAnimator animator=ObjectAnimator.ofFloat(home_showPhoto,"translationY",-hight,0);
        animator.setDuration(duration);
        animator.start();
    }
    public void setWelcomeImgs(final String url){
            new Thread(){
                @Override
                public void run() {

                    try {
                        bitmap= Glide.with(LoseWeightFragment.this)
                                .load(url)
                                .asBitmap()
                                .centerCrop()
                                .into(width, home_welcome_imgs.getHeight())
                                .get();
                        handler.sendEmptyMessage(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }.start();


    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            home_welcome_imgs.setBackground(new BitmapDrawable(bitmap));
        }
    };
}
