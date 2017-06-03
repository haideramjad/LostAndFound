package com.example.haider.networking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by haider on 5/14/17.
 */

public class login {
    @Expose
    @SerializedName("email")
    private String email;
    @Expose
    @SerializedName("password")
    private String password;
    @Expose
    @SerializedName("bolean")
    private String bolean;
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getBolean() {
        return bolean;
    }
}
