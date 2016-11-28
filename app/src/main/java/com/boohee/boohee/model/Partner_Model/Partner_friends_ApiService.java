package com.boohee.boohee.model.Partner_Model;

import com.boohee.boohee.Bean.shop_Bean.partner_Bean.Partner_friends;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Huochai on 2016/11/24.
 */

public interface Partner_friends_ApiService {
    @GET("api/v1/home_timeline")
    Observable<Partner_friends> getPartnerf(@Query("status_api_version") String status_api_version, @Query("token") String token, @Query("user_key") String user_key);

}
