package com.example.usd_eur.Model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Result {

    @SerializedName("lastupdate")
    private String lastupdate;

    @SerializedName("data")
    private ArrayList<Data1> data;

    public String getLastupdate() {
        return lastupdate;
    }

    public ArrayList<Data1> getData() {
        return data;
    }
}
