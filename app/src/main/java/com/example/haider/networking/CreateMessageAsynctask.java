package com.example.haider.networking;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by haider on 5/20/17.
 */

public class CreateMessageAsynctask extends AsyncTask<Object, Object, String> {
    String json;
    String title , message , product ;
    Activity activity;

    public CreateMessageAsynctask(String title, String message, String product, Activity activity) {
        this.title = title;
        this.message = message;
        this.product = product;
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Object... voids) {

        OkHttpClient client = new OkHttpClient();
        RequestBody formbody = new FormBody.Builder()
                .add("title" , title)
                .add("message" , message)
                .add("product" , product)
                .build();


        Request request = new Request.Builder()
                .url("http://192.168.1.20/message_app/api/create")
                .post(formbody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            json = response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(activity , "Added" , Toast.LENGTH_SHORT).show();
        ListResponse listResponse = new ListResponse(activity);
        listResponse.execute();
    }

}
