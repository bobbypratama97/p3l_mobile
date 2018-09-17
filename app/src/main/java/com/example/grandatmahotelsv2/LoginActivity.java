package com.example.grandatmahotelsv2;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.grandatmahotelsv2.model.Value;
import com.example.grandatmahotelsv2.model.loginList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.xml.sax.helpers.LocatorImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import API.LoginAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private EditText txtUsername;
    private EditText txtPassword;
    private final String USER_NAME="username";
    Button btnLogin;

    String username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsername = findViewById(R.id.unameText);
        txtPassword = findViewById(R.id.passwordText);
        btnLogin = findViewById(R.id.btnLogin);


       //validasiLogin(this);
    }

   /* private void validasiLogin(LoginActivity loginActivity) {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }*/

  /*  public void validasiLogin(View view){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }*/

    public void login(final View v){


        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String username,password;


                try{
                    username=txtUsername.getText().toString().trim();
                    Toast.makeText(LoginActivity.this,username,Toast.LENGTH_SHORT).show();
                    password=txtPassword.getText().toString().trim();
                    Toast.makeText(LoginActivity.this,password,Toast.LENGTH_SHORT).show();
                    final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                    progressDialog.setMessage("Signing in..");
                    progressDialog.show();

                    Retrofit retrofit=new Retrofit.Builder()
                                     .baseUrl("http://192.168.0.103/Android/")
                                     .addConverterFactory(GsonConverterFactory.create())
                                     .build();

                    LoginAPI api=retrofit.create(LoginAPI.class);
                    Call<loginList> call= api.login(username,password);
                    call.enqueue(new Callback<loginList>() {
                        @Override
                        public void onResponse(Call<loginList> call, Response<loginList> response) {
                            progressDialog.dismiss();
                            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                            intent.putExtra("IdUser",response.body().getResult().get(0).getIdUser());
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<loginList> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "No", Toast.LENGTH_SHORT).show();
                        }
                    });


                }catch (Exception e){

                }

            }
        });

    }
}
