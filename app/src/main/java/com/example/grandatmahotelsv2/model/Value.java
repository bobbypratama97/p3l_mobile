package com.example.grandatmahotelsv2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Value {
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("message")
    @Expose
    private String message;
    List<Season> result;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Season> getResult(){
        return result;
    }
}
