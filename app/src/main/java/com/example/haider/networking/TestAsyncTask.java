package com.example.haider.networking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.haider.networking.models.MyAsyncTask;

public class TestAsyncTask extends AppCompatActivity {
    RequestQueue queue;
    JsonObjectRequest jsonObjectRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_async_task);
        MyAsyncTask myAsyncTask=new MyAsyncTask(this);
        myAsyncTask.execute();
//        queue = Volley.newRequestQueue(this);
//        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, "http://192.168.1.10/message_app/api/read", null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                Toast.makeText(TestAsyncTask.this, "response"+response, Toast.LENGTH_SHORT).show();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(), "Volley Error"+error, Toast.LENGTH_SHORT).show();
//            }
//        });
//        queue.add(jsonObjectRequest);
    }
}
