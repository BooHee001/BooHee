package com.boohee.boohee.fragment.ShopFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by as on 2016/11/21.
 */

public class Shop_Details_GoodsFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv = new TextView(getContext());
        Bundle bundle = getArguments();
        int id = bundle.getInt("id");

        tv.setText("商品"+id);
        return tv;
    }
}
