package com.example.grandatmahotelsv2;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    Button btnAbout;
    Integer IdUser;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAbout = findViewById(R.id.btnAbout);

        Intent intent = getIntent();
        IdUser = intent.getIntExtra("IdUser",0);

    }

    public void about(View v)
    {
        Intent  intent = new Intent(MainActivity.this,ViewAbout.class);
        startActivity(intent);
    }

    public void faq(View v)
    {
        Intent intent = new Intent(MainActivity.this,viewFAQ.class);
        startActivity(intent);
    }

    public void contact(View v)
    {
        Intent intent = new Intent(MainActivity.this,ViewContact.class);
        startActivity(intent);
    }

    public void season(View v)
    {
        Intent intent = new Intent(MainActivity.this,ViewSeason.class);
        startActivity(intent);
    }

    public void gallery(View v)
    {
        Intent intent = new Intent(MainActivity.this,ViewGallery.class);
        startActivity(intent);
    }

    public void report1(View v)
    {
        Intent intent = new Intent(MainActivity.this,reportPelangganBaru.class);
        startActivity(intent);
    }

    public void report2(View v)
    {
        Intent intent = new Intent(MainActivity.this,reportPesananTerbanyak.class);
        startActivity(intent);
    }

    public void history(View v)
    {
        Intent intent = new Intent(MainActivity.this,lihathistoryreservasi.class);
        startActivity(intent);
    }

    public void reciept(View v)
    {
        Intent intent = new Intent(MainActivity.this,lihattandaterima1.class);
        startActivity(intent);
    }

    public void signout(View v){
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    public void editProfile(View v){
        Intent intent = new Intent(MainActivity.this,editprofile.class);
        intent.putExtra("IdUser",IdUser);
        startActivity(intent);
    }




    /*private EditText editTextFirstName,editTextLastName,editTextInstitutionName,editTextIdentityNumber,editTextPhoneNumber,editTextEmailAddress,editTextAddress,editTextUsername,editTextPassword;
    private EditText editTextIdUser,editTextIdType,editTextIdRole;
    private Button ButtonSubmit;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFirstName = findViewById(R.id.txtFirstName);
        editTextLastName = findViewById(R.id.txtLastName);
        editTextInstitutionName =  findViewById(R.id.txtInstitutionName);
        editTextIdentityNumber =  findViewById(R.id.txtIdentityNumber);
        editTextPhoneNumber =  findViewById(R.id.txtPhoneNumber);
        editTextEmailAddress =  findViewById(R.id.txtEmailAddress);
        editTextAddress =  findViewById(R.id.txtAddress);
        editTextUsername = findViewById(R.id.txtUsername);
        editTextPassword = findViewById(R.id.txtPassword);
        editTextIdUser = findViewById(R.id.txtIdUser);
        editTextIdType = findViewById(R.id.txtIdType);
        editTextIdRole = findViewById(R.id.txtIdRole);



        ButtonSubmit = findViewById(R.id.buttonSubmit);
        progressDialog = new ProgressDialog(this);

        ButtonSubmit.setOnClickListener(this);



    }

    private void registerUser(){
        final String FirstName = editTextFirstName.getText().toString().trim();
        final String LastName = editTextLastName.getText().toString().trim();
        final String InstitutionName = editTextInstitutionName.getText().toString().trim();
        final String IdentityNumber = editTextIdentityNumber.getText().toString().trim();
        final String PhoneNumber = editTextPhoneNumber.getText().toString().trim();
        final String EmailAddress = editTextEmailAddress.getText().toString().trim();
        final String Address = editTextAddress.getText().toString().trim();
        final String Username = editTextUsername.getText().toString().trim();
        final String Password = editTextPassword.getText().toString().trim();
        final Integer IdUser = Integer.parseInt(editTextIdUser.getText().toString());
        final Integer IdType = Integer.parseInt(editTextIdType.getText().toString());
        final Integer IdRole = Integer.parseInt(editTextIdRole.getText().toString());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Calendar RegistrationDate = Calendar.getInstance();
        final String RegistrationDate2 = dateFormat.format(RegistrationDate);

        // final DateFormat RegistrationDate = new SimpleDateFormat("yyyy-MM-dd");
       // final dateFormat RegistrationDate = Calendar.getInstance().getTime()


        progressDialog.setMessage("Registering user...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                            progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                           Toast.makeText(getApplicationContext(),jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("FirstName",FirstName);
                params.put("LastName",LastName);
                params.put("InstitutionName",InstitutionName);
                params.put("IdentityNumber",IdentityNumber);
                params.put("PhoneNumber",PhoneNumber);
                params.put("EmailAddress",EmailAddress);
                params.put("Address",Address);
                params.put("Username",Username);
                params.put("Password",Address);
                params.put("IdUser",String.valueOf(IdUser));
                params.put("IdType",String.valueOf(IdType));
                params.put("IdRole",String.valueOf(IdRole));
                params.put("RegistrationDate",RegistrationDate2);


                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    @Override
    public void onClick(View v) {
        if(v == ButtonSubmit)
            registerUser();
    }*/
}