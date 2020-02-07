package com.example.retrofitwetherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofitwetherapp.pojo.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kyivWeatherResponse();

    }

    public void kyivWeatherResponse(){
        App.getWeatherApi().getCountry("Kyiv" ,"8b69a9dda5b09ecc27f44c3f09ff04d2" , "metric").enqueue(new Callback<WeatherPojo>() {
            @Override
            public void onResponse(Call<WeatherPojo> call, Response<WeatherPojo> response) {
                if(response.isSuccessful()) {
                    Log.d("MyTag", "onResponse: " );
                    WeatherPojo weather = response.body();
                }
            }

            @Override
            public void onFailure(Call<WeatherPojo> call, Throwable t) {
                Log.d("MyTag", "onFailure: " + t.getMessage());
            }
        });
    }

}
