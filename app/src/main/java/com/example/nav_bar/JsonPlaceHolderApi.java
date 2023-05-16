package com.example.nav_bar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("services")
    Call<List<Post>> listRepos();
    @GET("hospitals")
    Call<List<Post>> listRepos2();

    @GET("users")
    Call<List<UserData>> getUsers();
}
