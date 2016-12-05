package com.boohee.boohee.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boohee.boohee.R;
import com.boohee.boohee.View.LoginActivity;
import com.boohee.boohee.View.MainActivity;
import com.boohee.boohee.View.Message_Classifcamation;
import com.boohee.boohee.View.Partner_View.Sift_reduce_WebView_Activity;
import com.boohee.boohee.View.Seek_Activity;

import static android.content.Context.MODE_WORLD_READABLE;
import static android.content.Context.MODE_WORLD_WRITEABLE;


/**
 * Created by Dizner on 2016/11/18.
 */

public class MeFragment extends Fragment {

    private RelativeLayout seek,message = null;
    private SharedPreferences sharedPreferences =null;
    private SharedPreferences.Editor editor =null;
    private  boolean isLogin;

    private RelativeLayout me_personaldata,me_MyPlan,me_DietQuotient,me_NICEService,me_Myfavs,me_MyFoods,me_smartdrvice,me_MyDiamond,me_question,me_setting = null;
    private LinearLayout me_trends,me_attention,me_fans = null;
    private TextView ZhuCe_Tex;
    private ImageView zhuce_Img;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me_fragment,container,false);


        initView(view);
        sharedPreferences =getActivity().getSharedPreferences("Login", MODE_WORLD_READABLE + MODE_WORLD_WRITEABLE);
        isLogin = sharedPreferences.getBoolean("islogin", false);
        int u_Id = sharedPreferences.getInt("userno", -1);
        String u_Pwd = sharedPreferences.getString("pwd", "null");
        if(isLogin){
            zhuce_Img.setVisibility(View.GONE);
            ZhuCe_Tex.setText(u_Id+"");
        }else {
            zhuce_Img.setVisibility(View.VISIBLE);
            ZhuCe_Tex.setText("请登录");

        }
        setOnclicks(view);


        return view;
    }


    public void initView(View view){

        seek = (RelativeLayout) view.findViewById(R.id.seek);
        message = (RelativeLayout) view.findViewById(R.id.message);

        me_personaldata = (RelativeLayout) view.findViewById(R.id.me_personaldata);
        me_MyPlan = (RelativeLayout) view.findViewById(R.id.me_MyPlan);
        me_DietQuotient = (RelativeLayout) view.findViewById(R.id.me_DietQuotient);
        me_NICEService = (RelativeLayout) view.findViewById(R.id.me_NICEService);
        me_Myfavs = (RelativeLayout) view.findViewById(R.id.me_Myfavs);
        me_MyFoods = (RelativeLayout) view.findViewById(R.id.me_MyFoods);
        me_smartdrvice = (RelativeLayout) view.findViewById(R.id.me_smartdrvice);
        me_MyDiamond = (RelativeLayout) view.findViewById(R.id.me_MyDiamond);
        me_question = (RelativeLayout) view.findViewById(R.id.me_question);
        me_setting = (RelativeLayout) view.findViewById(R.id.me_setting);

        me_trends = (LinearLayout) view.findViewById(R.id.me_trends);
        me_attention = (LinearLayout) view.findViewById(R.id.me_attention);
        me_fans = (LinearLayout) view.findViewById(R.id.me_fans);
        ZhuCe_Tex = (TextView) view.findViewById(R.id.ZhuCe_Tex);
        zhuce_Img = (ImageView) view.findViewById(R.id.zhuce_Img);

    }

    public void setOnclicks(View view){
        me_NICEService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Sift_reduce_WebView_Activity.class));
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Message_Classifcamation.class));
            }
        });
        seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Seek_Activity.class));
            }
        });
        me_personaldata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isLogin){
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    getContext().startActivity(intent);
                }
            }
        });
        me_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences login = getContext().getSharedPreferences("Login", MODE_WORLD_READABLE + MODE_WORLD_WRITEABLE);
                SharedPreferences.Editor edit = login.edit();
                edit.putBoolean("islogin", false);
                edit.commit();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("fragment", 3);
               getContext().startActivity(intent);

            }
        });

    }


}
