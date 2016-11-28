package com.boohee.boohee.model.Shop_Model;

import com.boohee.boohee.Bean.shop_Bean.Shop_Goods;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by as on 2016/11/20.
 */

public interface Shop_ApiSerVice {
    @GET("api/v1/shop_home")
    Observable<Shop_Goods> getShopGoods(@Query("version") int version, @Query("token") String token , @Query("user_key") String user_Key);

    @POST("MyAndroidDemo/MySerVlet?type=7")
    Observable<String>addGoodsCar(@Query("userno") int userno,@Query("goodsname") String goodsname,@Query("goodsimg") String goodsimg,@Query("goodspic") int goodspic,@Query("goodsnum") int goodsnum);
//    @GET("MyAndroidDemo/MySerVlet?type=4")
//    Observable<String> getGoodsCarBeanList(@Query("userno") int userno);
}
