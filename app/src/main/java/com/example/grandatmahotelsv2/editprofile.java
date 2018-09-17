package com.example.grandatmahotelsv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grandatmahotelsv2.model.loginList;

import API.LoginAPI;
import API.UserAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class editprofile extends AppCompatActivity {

    private Integer IdUser;
    private TextView txtFirstName;
    private TextView txtLastName;
    private TextView txtPassword;
    private TextView txtConfirmPassword;
    private TextView txtAddress;
    private TextView txtPhoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        Intent intent = getIntent();
        IdUser = intent.getIntExtra("IdUser",0);

        txtFirstName = (TextView) findViewById(R.id.firstNameText);
        txtLastName = (TextView) findViewById(R.id.lastNameText);
        txtPassword = (TextView) findViewById(R.id.passText);
        txtConfirmPassword = (TextView) findViewById(R.id.confirmPassText);
        txtAddress = (TextView) findViewById(R.id.addressText);
        txtPhoneNumber = (TextView) findViewById(R.id.phoneText);

        tampilUser();
    }

    public void tampilUser()
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.0.103/Android/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserAPI api=retrofit.create(UserAPI.class);
        Log.d("idBobby",String.valueOf(IdUser));
        Call<loginList> call = api.showData(IdUser);

        call.enqueue(new Callback<loginList>() {
            @Override
            public void onResponse(Call<loginList> call, Response<loginList> response) {
                Toast.makeText(editprofile.this, response.body().getResult().get(0).getFirstName(), Toast.LENGTH_SHORT).show();

                txtFirstName.setText(response.body().getResult().get(0).getFirstName());
                txtLastName.setText(response.body().getResult().get(0).getLastName());
                txtPassword.setText(response.body().getResult().get(0).getPassword());
                txtConfirmPassword.setText(response.body().getResult().get(0).getPassword());
                txtAddress.setText(response.body().getResult().get(0).getAddress());
                txtPhoneNumber.setText(response.body().getResult().get(0).getPhoneNumber());


            }

            @Override
            public void onFailure(Call<loginList> call, Throwable t) {
                Toast.makeText(editprofile.this, "gagal", Toast.LENGTH_SHORT).show();

            }
        });
    }









}
