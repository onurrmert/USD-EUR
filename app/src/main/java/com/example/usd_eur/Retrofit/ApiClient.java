package com.example.usd_eur.Retrofit;

import androidx.annotation.NonNull;
import com.example.usd_eur.Model.Root1;
import com.example.usd_eur.Utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit getRetrofit(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Gson gsonBuilder = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder()
                .baseUrl(Constants.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
                .client(httpClient.build())
                .build();
    }

    public static IForeignCurrency getApi(){
        return ApiClient.getRetrofit().create(IForeignCurrency.class);
    }
}
