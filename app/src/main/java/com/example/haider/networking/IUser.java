package com.example.haider.networking;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by haider on 5/14/17.
 */

public interface IUser {
    @POST("check")
    Call<login> loginUser(@Body HashMap<String, Object> paramHashMap);

    @POST("register")
    Call<register> registerUser(@Body HashMap<String, Object> paramHashMap);
}
