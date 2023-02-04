package com.example.usd_eur.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "foreignCurrencyTable")
public class Data1 {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private final String name;

    @SerializedName("code")
    @ColumnInfo(name = "code")
    private final String code;

    @SerializedName("rate")
    @ColumnInfo(name = "rate")
    private final double rate;

    public Data1(long id, String name, String code, double rate) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.rate = rate;
    }

    @Ignore
    public Data1(String name, String code, double rate) {
        this.name = name;
        this.code = code;
        this.rate = rate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getRate() {
        return rate;
    }
}
