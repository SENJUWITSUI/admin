package com.example.nav_bar;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {
//    @POST("users")
//    Call<Hospitals> createHospital(@Body Hospitals hospitals);
//
//    @FormUrlEncoded
//    @POST("hospitals")
//    Call<Hospitals> createHospital (
//            @Field("hospital_name")String hospital_name,
//            @Field("homis")String homis
//    );

    @GET("services")
    Call<List<service>> getServices();

}
