package com.example.nav_bar;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String  API_BASE_URL = "http://10.20.108.119:8080/api/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    public RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)  //Change server URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized RetrofitClient getInstance(){
        if (mInstance == null){
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }
    public RetrofitAPI getRetrofitApi(){
        return retrofit.create(RetrofitAPI.class);
    }
}
