package com.example.grandatmahotelsv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.grandatmahotelsv2.adapter.RecyclerViewAdapterFAQ;
import com.example.grandatmahotelsv2.model.faq;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class viewFAQ extends AppCompatActivity {

    private static final String URL = "http://192.168.0.167/Android/apiFAQ.php";
    RecyclerView recyclerView;
    RecyclerViewAdapterFAQ adapter;
    List<faq> faqList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_faq);

        faqList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadFaq();




    }

    private void loadFaq() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray faq = new JSONArray(response);

                    for(int i=0;i<faq.length();i++){
                        JSONObject faqObject = faq.getJSONObject(i);

                        int IdFaq = faqObject.getInt("IdFaq");
                        String Question = faqObject.getString("Question");
                        String Answer = faqObject.getString("Answer");

                        faq faq2 = new faq(IdFaq,Question,Answer);
                        faqList.add(faq2);
                    }
                    adapter = new RecyclerViewAdapterFAQ(viewFAQ.this, faqList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(viewFAQ.this,error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }
    public void home(View v)
    {
        Intent intent = new Intent(viewFAQ.this,MainActivity.class);
        startActivity(intent);
    }
}
