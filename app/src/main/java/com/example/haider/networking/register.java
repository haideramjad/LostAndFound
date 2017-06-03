package com.example.haider.networking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by haider on 5/17/17.
 */

public class register {
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("email")
        private String email;
        @Expose
        @SerializedName("password")
        private String password;
        @Expose
        @SerializedName("bolean")
        private String bolean;

    public String getName() {
        return this.name;
    }

    public String getEmail(){
            return this.email;
        }
        public String getPassword(){
            return this.password;
        }

        public String getBolean() {
            return bolean;
        }
}
