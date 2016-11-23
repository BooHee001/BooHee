package com.boohee.boohee.model;

import com.boohee.boohee.PhotoBean.PhotoBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Dizner on 2016/11/19.
 */

public interface ApiService {

    @GET("api/v1/home/items?token=w9eSJ5JcC3sySFicgim2&user_key=eabcb76b-eb40-4aa1-b3e8-6529106d6214&app_version=5.6.3.1&app_device=Android&os_version=6.0.1&phone_model=ATH-AL00&channel=huawei&app_key=one")
    Call<PhotoBean> getPhotoList();
}
