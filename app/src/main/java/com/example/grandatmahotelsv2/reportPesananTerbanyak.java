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
import com.example.grandatmahotelsv2.adapter.RecyclerViewAdapterREPORT2;
import com.example.grandatmahotelsv2.adapter.RecyclerViewAdapterSEASON;
import com.example.grandatmahotelsv2.model.Season;
import com.example.grandatmahotelsv2.model.report2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class reportPesananTerbanyak extends AppCompatActivity {
    private static final String URL = "http://192.168.0.167/Android/apiREPORT2.php";
    RecyclerView recyclerView;
    RecyclerViewAdapterREPORT2 adapter;
    List<report2> report2List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_pesanan_terbanyak);

        report2List = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewR2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadreport2();
    }

    private void loadreport2() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray report2 = new JSONArray(response);

                    for(int i=0;i<report2.length();i++){
                        JSONObject report2Object = report2.getJSONObject(i);

                        String NAMA = report2Object.getString("NAMA");
                        int JUMLAH_RESERVASI = report2Object.getInt("JUMLAH_RESERVASI");
                        int TOTAL_PEMBAYARAN = report2Object.getInt("TOTAL_PEMBAYARAN");


                        report2 report2B = new report2(NAMA,JUMLAH_RESERVASI,TOTAL_PEMBAYARAN);
                        report2List.add(report2B);
                    }
                    adapter = new RecyclerViewAdapterREPORT2(reportPesananTerbanyak.this, report2List);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(reportPesananTerbanyak.this,error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void home(View v)
    {
        Intent intent = new Intent(reportPesananTerbanyak.this,MainActivity.class);
        startActivity(intent);
    }


}
