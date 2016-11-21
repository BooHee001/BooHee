package com.boohee.boohee.model.Shop_Model;

import com.boohee.boohee.Bean.Shop_Bean.Shop_Goods;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by as on 2016/11/20.
 */

public interface Shop_ApiSerVice {
    @GET("api/v1/shop_home")
    Call<Shop_Goods> getShopGoods(@Query("version") int version,@Query("token") String token ,@Query("user_key") String user_Key);

}
