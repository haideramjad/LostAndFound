package com.example.haider.networking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AdminPanel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        ListResponse listResponse = new ListResponse(this);
        listResponse.execute();


    }
    private Boolean exit = true;
    @Override
    public void onBackPressed() {
        if (exit)
        {
            finish();
        }
          }
}
