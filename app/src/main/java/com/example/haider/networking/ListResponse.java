package com.example.haider.networking;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by haider on 5/20/17.
 */



public class ListResponse extends AsyncTask<Object, Object, String> {
    String json;
    Activity activity;

    public ListResponse(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Object... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://192.168.1.20/message_app/api/read")
                .get()
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
        Gson gson = new Gson();
        List<MessagePojo> message = gson.fromJson(s , new TypeToken< ArrayList<MessagePojo>>(){}.getType() );
        FragmentManager fragmentManager = ((AdminPanel) activity).getSupportFragmentManager();
        Listview listView = new Listview(message , activity);
        fragmentManager.beginTransaction().replace(R.id.fragmentwrapper , listView).commit();
    }
}
