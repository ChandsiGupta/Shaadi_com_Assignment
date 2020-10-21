package com.example.shaadi_assignment_.api;

import com.example.shaadi_assignment_.model.Root;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/api")
    Call<Root> getUserList(@Query("results") String limit);
}