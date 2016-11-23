package com.boohee.boohee.adapter;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.boohee.boohee.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Dizner on 2016/11/19.
 */

public class PhotoAdapter extends PagerAdapter {
    private final int hight;
    private final int width;
    private List<String> list;
    private Activity activity;
    private float lastY = 0;
    private float lastX = 0;
    private static boolean isUp = false;
    private ViewPager home_photo;

    public PhotoAdapter(List<String> list, Activity activity) {
        this.activity = activity;
        this.list = list;
        hight = activity.getWindowManager().getDefaultDisplay().getHeight();
        width = activity.getWindowManager().getDefaultDisplay().getWidth();
        home_photo= (ViewPager) activity.findViewById(R.id.home_showPhoto);
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView iv = new ImageView(activity);
        iv.setAdjustViewBounds(true);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(activity).load(list.get(position)).into(iv);
//        x.image().bind(iv,"http://up.boohee.cn/house/u/one/wallpaper/104_small_v2.jpg");
//        iv.setLayoutParams(new ViewPager.LayoutParams());
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
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }

    private void setAnim(int duration) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(home_photo, "translationY", 0, -hight);
        animator.setDuration(duration);
        animator.start();
    }
}
