package com.example.grandatmahotelsv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ViewAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_about);
    }

    public void home(View v)
    {
        Intent intent = new Intent(ViewAbout.this,MainActivity.class);
        startActivity(intent);
    }
}
