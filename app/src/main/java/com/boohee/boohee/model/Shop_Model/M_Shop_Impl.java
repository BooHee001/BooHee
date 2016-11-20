package com.boohee.boohee.model.Shop_Model;

import com.boohee.boohee.Bean.Shop_Bean.Shop_Goods;
import com.boohee.boohee.presenter.Shop_Presenter.P_Shop;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by as on 2016/11/20.
 */

public class M_Shop_Impl implements M_Shop {
    P_Shop p_shop;

    public M_Shop_Impl(P_Shop p_shop) {
        this.p_shop = p_shop;
    }

    @Override
    public void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://180.153.222.195")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Shop_ApiSerVice shop_apiSerVice = retrofit.create(Shop_ApiSerVice.class);
        Call<Shop_Goods> call = shop_apiSerVice.getShopGoods(4, "w9eSJ5JcC3sySFicgim2", "eabcb76b-eb40-4aa1-b3e8-6529106d6214");
        call.enqueue(new Callback<Shop_Goods>() {
            @Override
            public void onResponse(Call<Shop_Goods> call, Response<Shop_Goods> response) {

                p_shop.setShopData(response.body());
            }

            @Override
            public void onFailure(Call<Shop_Goods> call, Throwable t) {

            }
        });


    }
}
