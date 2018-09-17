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
import com.example.grandatmahotelsv2.adapter.RecyclerViewAdapterREPORT1;
import com.example.grandatmahotelsv2.adapter.RecyclerViewAdapterSEASON;
import com.example.grandatmahotelsv2.model.Season;
import com.example.grandatmahotelsv2.model.report1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class reportPelangganBaru extends AppCompatActivity {

    private static final String URL = "http://192.168.0.167/Android/apiREPORT1.php";
    RecyclerView recyclerView;
    RecyclerViewAdapterREPORT1 adapter;
    List<report1> report1List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_pelanggan_baru);

        report1List = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewR);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadreport1();
    }
    private void loadreport1() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray report1 = new JSONArray(response);

                    for(int i=0;i<report1.length();i++){
                        JSONObject report1Object = report1.getJSONObject(i);

                        int BULAN = report1Object.getInt("BULAN");
                        int JUMLAH = report1Object.getInt("JUMLAH");



                        report1 report1B = new report1(BULAN,JUMLAH);
                        report1List.add(report1B);
                    }
                    adapter = new RecyclerViewAdapterREPORT1(reportPelangganBaru.this, report1List);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(reportPelangganBaru.this,error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void home(View v)
    {
        Intent intent = new Intent(reportPelangganBaru.this,MainActivity.class);
        startActivity(intent);
    }
}
