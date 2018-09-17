package com.example.grandatmahotelsv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class pembatalanReservasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembatalan_reservasi);
    }

    public void home(View v)
    {
        Intent intent = new Intent(pembatalanReservasi.this,MainActivity.class);
        startActivity(intent);
    }
}
