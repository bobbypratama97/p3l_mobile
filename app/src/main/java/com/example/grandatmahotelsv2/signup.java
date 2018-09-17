package com.example.grandatmahotelsv2;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.grandatmahotelsv2.model.Value;

import java.util.Calendar;
import java.util.Date;

import API.signupAPI;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class signup extends AppCompatActivity {


    public static final String URL = "http://192.168.0.110/Android/";
    private ProgressDialog progressDialog;
    Integer IdUser, IdType, IdRole;
    String FirstName, LastName, Institutionname, IdentityNumber, PhoneNumber, EmailAddress, Address, Username, Password, RegistrationDate2;
    Date RegistrationDate;
    Button button;
    EditText txtFirstName,txtLastName,txtInstitutionName,txtIdentityNumber,txtPhoneNumber,txtEmailAddress,txtAddress,txtUsername,txtPassword,txtIdUser,txtIdType,txtIdRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        button = (Button)findViewById(R.id.buttonSubmit);
        txtFirstName = (EditText)findViewById(R.id.txtFirstName);
        txtLastName = (EditText)findViewById(R.id.txtLastName);
        txtInstitutionName = (EditText)findViewById(R.id.txtInstitutionName);
        txtIdentityNumber = (EditText)findViewById(R.id.txtIdentityNumber);
        txtPhoneNumber = (EditText)findViewById(R.id.txtPhoneNumber);
        txtEmailAddress = (EditText)findViewById(R.id.txtEmailAddress);
        txtAddress = (EditText)findViewById(R.id.txtAddress);
        txtUsername = (EditText)findViewById(R.id.txtUsername);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        txtIdUser = (EditText)findViewById(R.id.txtIdUser) ;
        txtIdType = (EditText)findViewById(R.id.txtIdType);
        txtIdRole = (EditText)findViewById(R.id.txtIdRole);


    }

    // @OnClick(com.example.grandatmahotelsv2.R.id.buttonSubmit)
    public void daftar(View v) {

        //untuk menampilkan progress dialog pada saat sesudah klik button submit
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              progressDialog = new ProgressDialog(signup.this);
              progressDialog.setCancelable(false);
              progressDialog.setMessage("Loading..");
              progressDialog.show();

                FirstName = txtFirstName.getText().toString();
                LastName = txtLastName.getText().toString();
                Institutionname = txtInstitutionName.getText().toString();
                IdentityNumber = txtIdentityNumber.getText().toString();
                PhoneNumber = txtPhoneNumber.getText().toString();
                EmailAddress = txtEmailAddress.getText().toString();
                Address = txtAddress.getText().toString();
                Username = txtUsername.getText().toString();
                Password = txtPassword.getText().toString();
                IdUser = Integer.parseInt(txtIdUser.getText().toString());
                IdRole = Integer.parseInt(txtIdRole.getText().toString());
                IdType = Integer.parseInt(txtIdType.getText().toString());
                RegistrationDate = Calendar.getInstance().getTime();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.0.167/Android/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                signupAPI api = retrofit.create(signupAPI.class);

                Call<Value> call = api.daftar(
                        IdUser,
                        IdType,
                        IdRole,
                        FirstName,
                        LastName,
                        Institutionname,
                        IdentityNumber,
                        PhoneNumber,
                        EmailAddress,
                        Address,
                        Username,
                        Password,
                        RegistrationDate);

                /**call.enqueue(new Callback<Value>() {
                    @Override
                    public void onResponse(Call<Value> call, Response<Value> response) {

                        String value = response.body().getValue2();
                        String message = response.body().getMessage();
                        progressDialog.dismiss();

                        if (value.equals("1")) {
                            Toast.makeText(signup.this, message, Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(signup.this, message, Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Value> call, Throwable t) {

                        t.printStackTrace();
                        progressDialog.dismiss();
                        Toast.makeText(signup.this, "Network Error!", Toast.LENGTH_SHORT).show();

                    }
                });*/


            }
        });


    }
}



