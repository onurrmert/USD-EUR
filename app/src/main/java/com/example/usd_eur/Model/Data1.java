package com.example.usd_eur.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "foreignCurrencyTable")
public class Data1 {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private final long id;
    @SerializedName("name")
    @ColumnInfo(name = "name")
    private final String name;
    @SerializedName("rate")
    @ColumnInfo(name = "rate")
    private final double rate;

    public Data1(long id, String name, double rate) {
        this.id = id;
        this.name = name;
        this.rate = rate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }
}
