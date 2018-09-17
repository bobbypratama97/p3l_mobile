package com.example.grandatmahotelsv2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class login {
    @SerializedName("IdUser")
    @Expose
    private Integer IdUser;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("PhoneNumber")
    @Expose
    private String phoneNumber;

    public Integer getIdUser() {
        return IdUser;
    }

    public void setIdUser(Integer idUser) {
        IdUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
