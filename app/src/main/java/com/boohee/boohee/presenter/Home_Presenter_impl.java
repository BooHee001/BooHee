package com.boohee.boohee.presenter;

import com.boohee.boohee.View.HomePhoto;
import com.boohee.boohee.model.Home_Model;
import com.boohee.boohee.model.Home_Model_impl;

/**
 * Created by Dizner on 2016/11/19.
 */

public class Home_Presenter_impl implements Home_Persenter {
    private Home_Model model;
    private HomePhoto view;

    public Home_Presenter_impl(HomePhoto view) {
        this.view = view;
        model = new Home_Model_impl(this);
    }

    @Override
    public void getData() {
        model.getData();
    }

    @Override
    public void setData() {
        view.loadData();
    }
}
