package com.example.retrofitwetherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServerApi serverApi = retrofit.create(ServerApi.class);
        serverApi.getCountry("Kyiv" ,"8b69a9dda5b09ecc27f44c3f09ff04d2" , "metric").enqueue(new Callback<PojoResponse>() {
            @Override
            public void onResponse(Call<PojoResponse> call, Response<PojoResponse> response) {
                if(response.isSuccessful()) {
                    Log.d("MyTag", "onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<PojoResponse> call, Throwable t) {
                Log.d("MyTag", "onFailure: " + t.getMessage());
            }
        });

    }
}
