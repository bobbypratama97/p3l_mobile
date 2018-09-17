package com.example.grandatmahotelsv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.grandatmahotelsv2.adapter.RecyclerViewAdapterSEASON;
import com.example.grandatmahotelsv2.model.Season;
import com.example.grandatmahotelsv2.model.Value;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import API.SeasonAPI;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewSeason extends AppCompatActivity {

    private static final String URL = "http://192.168.0.167/Android/apiSEASON.php";
    RecyclerView recyclerView;
    RecyclerViewAdapterSEASON adapter;
    List<Season> seasonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_season);

        seasonList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadSeason();




    }

    private void loadSeason() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray season = new JSONArray(response);

                    for(int i=0;i<season.length();i++){
                        JSONObject seasonObject = season.getJSONObject(i);

                        String StartDate = String.valueOf(seasonObject.get("StartDate"));
                        String EndDate = String.valueOf(seasonObject.get("EndDate"));


                        int IdSeason = seasonObject.getInt("IdSeason");
                        int IdPrice = seasonObject.getInt("PriceNominal");
                        String SeasonName = seasonObject.getString("SeasonName");
                        String Detail = seasonObject.getString("Detail");


                        Season season2 = new Season(IdSeason,IdPrice,SeasonName,StartDate,EndDate,Detail);
                        seasonList.add(season2);
                    }
                    adapter = new RecyclerViewAdapterSEASON(ViewSeason.this, seasonList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewSeason.this,error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void home(View v)
    {
        Intent intent = new Intent(ViewSeason.this,MainActivity.class);
        startActivity(intent);
    }

}
