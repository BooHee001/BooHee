package com.boohee.boohee.model.Partner_Model;

import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.Partner_sift;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Huochai on 2016/11/22.
 */

public interface Partner_ApiService {
    @GET("api/v1/channels/posts")

    Observable<Partner_sift> getPartner(@Query("slug") String slug,@Query("token") String token,@Query("user_key") String user_key);

}
