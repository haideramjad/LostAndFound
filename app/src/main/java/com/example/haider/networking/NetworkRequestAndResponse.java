package com.example.haider.networking;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by haider on 5/6/17.
 */
public class NetworkRequestAndResponse{

    @NonNull
    public static Retrofit retrofit() {
        return new Retrofit.Builder().baseUrl("http://192.168.1.20/message_app/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    }
}