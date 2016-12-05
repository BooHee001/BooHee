package com.boohee.boohee.model.Partner_Model;


import com.boohee.boohee.Bean.shop_Bean.partner_Bean.Partner_ViewPager;




import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Huochai on 2016/11/24.
 */

public interface Partner_ViewPager_ApiService {
//    http://139.196.2.133/api/v1/app_square/light?token=b6LUSVkfgNK9sWjX2SMV&user_key=6a50362e-ab24-4240-b630-581de4dc240c&app_version=5.6.3.1&app_device=Android&os_version=6.0.1&phone_model=Nexus+5&channel=_360&app_key=one
    @GET("api/v1/app_square/light")
    Observable<Partner_ViewPager> getPartnerV(@Query("token") String token, @Query("user_key") String user_key, @Query("app_version") String app_version);


}
