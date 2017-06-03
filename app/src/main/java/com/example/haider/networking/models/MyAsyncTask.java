package com.example.haider.networking.models;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by haider on 5/20/17.
 */

public class MyAsyncTask extends AsyncTask<String, String, String>{
    private static Context context;
    ProgressDialog progressDialog;
    OkHttpClient client = new OkHttpClient();
    //final ArrayList<Timetable> list = new ArrayList<Timetable>();

    public MyAsyncTask(Context c) {
        context = c;
    }
//
//    Onstart onstart;
//
//    public interface Onstart {
//        void getstart(ArrayList<Timetable> list);
//
//    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //onstart = (Onstart) context;
//        progressDialog = ProgressDialog.show(context,
//                "",
//
//                "Wait......");
    }

    @Override
    protected String doInBackground(String... params) {
            Request request = new Request.Builder()
                    .url("http://192.168.1.10/message_app/api/read")
                    .get()
                    .build();
            try {
                Response response = client.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                e.printStackTrace();
            }

        return "true";

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, "Retured "+s, Toast.LENGTH_LONG).show();
        try {
            JSONArray jsonArray=new JSONArray(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        progressDialog.dismiss();

    }
}
