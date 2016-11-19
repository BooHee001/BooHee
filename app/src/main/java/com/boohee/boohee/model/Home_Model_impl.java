package com.boohee.boohee.model;

import com.boohee.boohee.presenter.Home_Persenter;

/**
 * Created by Dizner on 2016/11/19.
 */

public class Home_Model_impl implements Home_Model {
    private Home_Persenter persenter;

    public Home_Model_impl(Home_Persenter persenter) {
        this.persenter = persenter;
    }

    @Override
    public void getData() {

    }
}
