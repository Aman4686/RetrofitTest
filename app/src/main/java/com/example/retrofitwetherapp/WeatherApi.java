package com.example.retrofitwetherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface WeatherApi {

    @GET("weather")
    Call<WeatherPojo> getCountry(@Query("q") String city , @Query("appid") String appid, @Query("units") String units);
}
