package com.boohee.boohee.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.boohee.boohee.R;
import com.boohee.boohee.View.Partner_View.Sift_reduce_WebView_Activity;


/**
 * Created by Dizner on 2016/11/18.
 */

public class MeFragment extends Fragment {

    private RelativeLayout seek,message = null;

    private RelativeLayout me_personaldata,me_MyPlan,me_DietQuotient,me_NICEService,me_Myfavs,me_MyFoods,me_smartdrvice,me_MyDiamond,me_question,me_setting = null;
    private LinearLayout me_trends,me_attention,me_fans = null;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me_fragment,container,false);


        initView(view);

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

    }

    public void setOnclicks(View view){
        me_NICEService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Sift_reduce_WebView_Activity.class));
            }
        });


    }


}
