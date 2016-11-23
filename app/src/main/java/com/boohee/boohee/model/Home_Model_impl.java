package com.boohee.boohee.model;

import com.boohee.boohee.PhotoBean.PhotoBean;
import com.boohee.boohee.presenter.Home_Persenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dizner on 2016/11/19.
 */

public class Home_Model_impl implements Home_Model {
    private Home_Persenter persenter;
    public static final String BASE_URL = "http://139.196.2.133";
    public Home_Model_impl(Home_Persenter persenter) {
        this.persenter = persenter;
    }

    @Override
    public void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<PhotoBean> photoList = api.getPhotoList();
        photoList.enqueue(new Callback<PhotoBean>() {
            @Override
            public void onResponse(Call<PhotoBean> call, Response<PhotoBean> response) {

                PhotoBean photo = response.body();
                persenter.setData(photo);

            }

            @Override
            public void onFailure(Call<PhotoBean> call, Throwable t) {

            }
        });

    }
}
