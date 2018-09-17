package com.example.grandatmahotelsv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.grandatmahotelsv2.adapter.RecyclerViewAdapterHISTORY;
import com.example.grandatmahotelsv2.adapter.RecyclerViewAdapterSEASON;
import com.example.grandatmahotelsv2.model.History;
import com.example.grandatmahotelsv2.model.Season;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class lihathistoryreservasi extends AppCompatActivity {

    private static final String URL = "http://192.168.0.167/Android/apiHISTORY.php";
    RecyclerView recyclerView;
    RecyclerViewAdapterHISTORY adapter;
    List<History> historyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihathistoryreservasi);

        historyList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewH);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadHistory();
    }

    private void loadHistory() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray History = new JSONArray(response);

                    for(int i=0;i<History.length();i++){
                        JSONObject historyObject = History.getJSONObject(i);

                        int IdBooking = historyObject.getInt("IdBooking");
                        String ReservationDate  = String.valueOf(historyObject.get("ReservationDate"));
                        String ReservationStatus = historyObject.getString("ReservationStatus");
                        String CheckInDate  = String.valueOf(historyObject.get("CheckInDate"));
                        String CheckOutDate  = String.valueOf(historyObject.get("CheckOutDate"));




                        History history2 = new History(IdBooking,ReservationDate,ReservationStatus,CheckInDate,CheckOutDate);
                        historyList.add(history2);
                    }
                    adapter = new RecyclerViewAdapterHISTORY(lihathistoryreservasi.this, historyList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(lihathistoryreservasi.this,error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void home(View v)
    {
        Intent intent = new Intent(lihathistoryreservasi.this,MainActivity.class);
        startActivity(intent);
    }
}
