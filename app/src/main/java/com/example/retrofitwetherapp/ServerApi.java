package com.example.retrofitwetherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

interface ServerApi {

    @GET("weather")
    Call<PojoResponse> getCountry(@Query("q") String country , @Query("appid") String appid, @Query("units") String units);
}
