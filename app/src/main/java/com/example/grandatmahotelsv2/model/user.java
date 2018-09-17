package com.example.grandatmahotelsv2.model;

import java.util.Date;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class user {

    Integer IdUser;
    Integer IdType;
    Integer IdRole;
    String FirstName;
    String LastName;
    String InstitutionName;
    String IdentityNumber;
    String PhoneNumber;
    String EmailAddress;
    String Address;
    String Username;
    String Password;
    Date RegistrationDate;

    public Integer getIdUser() {
        return IdUser;
    }

    public Integer getIdType() {
        return IdType;
    }

    public Integer getIdRole() {
        return IdRole;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getInstitutionName() {
        return InstitutionName;
    }

    public String getIdentityNumber() {
        return IdentityNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public String getAddress() {
        return Address;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public Date getRegistrationDate() {
        return RegistrationDate;
    }
}
