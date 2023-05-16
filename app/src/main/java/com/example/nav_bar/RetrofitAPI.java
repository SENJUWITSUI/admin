package com.example.nav_bar;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitAPI {
     @GET("services")
    Call<List<Post>> listRepos();
    @GET("hospitals")
    Call<List<Post>> listRepos2();

    @GET("users")
    Call<List<UserData>> getUsers();

    @GET("services")
    Call<List<service>> getServices();

//    @GET("services")
//    static Call<List<service>> getData(@Query("search") String searchText) {
//        return null;
//    }

}
