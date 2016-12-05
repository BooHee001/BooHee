package com.boohee.boohee.model;



import com.boohee.boohee.PhotoBean.Seek_Bean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Huochai on 2016/11/28.
 */

public interface Seek_ApiService {
    @GET("v2/ifoods/keywords")
    Observable<Seek_Bean> getSeek(@Query("token") String token, @Query("user_key") String user_key);
//    ,@Query("app_version") String app_version

}

//http://180.153.222.195/v2/ifoods/keywords?token=w9eSJ5JcC3sySFicgim2&user_key=eabcb76b-eb40-4aa1-b3e8-6529106d6214&app_version=5.6.3.1&app_device=Android&os_version=6.0.1&phone_model=ATH-AL00&channel=huawei

