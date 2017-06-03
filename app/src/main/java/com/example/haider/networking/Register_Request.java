package com.example.haider.networking;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by haider on 5/16/17.
 */

public class Register_Request {
    @NonNull
    public static Retrofit retrofit() {
        return new Retrofit.Builder().baseUrl("http://192.168.1.20/message_app/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    }
}
