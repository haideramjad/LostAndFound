package com.example.haider.networking;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by haider on 5/20/17.
 */

public class CreateAsyncTask extends AsyncTask<String, String, String> {
    private static Context context;
    ProgressDialog progressDialog;
    /*SharedPreferences sharedPreferences;*/
    OkHttpClient client = new OkHttpClient();

    public CreateAsyncTask(Context c) {
        context = c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context,
                "Login",
                "Wait......");
    }

    @Override
    protected String doInBackground(String... params) {
        /*sharedPreferences = context.getSharedPreferences("mypreference", Context.MODE_PRIVATE);*/
        try {
            Thread.sleep(2000);
            RequestBody formBody = new FormBody.Builder()
                    .add("title", params[0])
                    .add("product", params[1])
                    .add("message", params[3])
                    .add("user_id", params[4])
                    .add("day", params[5])
                    .add("date", params[6])
                    .add("place", params[7])
                    .add("time", params[8])
                    .build();
            Request request = new Request.Builder()
                    .url("http://192.168.1.20/mad_project/userregister")
                    .post(formBody)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    String name = null;
    String email = null;
    String password = null;

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s.equals("register")) {
            progressDialog.dismiss();
            Toast.makeText(context, "User Registered", Toast.LENGTH_SHORT).show();
            FragmentTransaction fragmentTransaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
            LoginFragment blankFragment = new LoginFragment();
            fragmentTransaction.replace(android.R.id.content, blankFragment).commit();
        } else {
            progressDialog.dismiss();
            Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
        }
    }

}
