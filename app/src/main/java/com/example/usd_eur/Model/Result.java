package com.example.usd_eur.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Result {
    @SerializedName("lastupdate")
    public String lastupdate;
    @SerializedName("data")
    public ArrayList<Data1> data;
}
