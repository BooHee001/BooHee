package com.boohee.boohee.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.boohee.boohee.R;

import butterknife.OnClick;

/**
 * Created by Dizner on 2016/11/18.
 */

public class MeFragment extends Fragment {





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me_fragment,container,false);
        return view;



    }

    @OnClick(R.id.me_personaldata)
    public void me_personaldata(View view){
        Toast.makeText(getActivity(), "123", Toast.LENGTH_SHORT).show();
    }

}
