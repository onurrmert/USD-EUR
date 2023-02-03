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

    public void getData(){

        IForeignCurrency foreignCurrency = ApiClient.getRetrofit().create(IForeignCurrency.class);

        foreignCurrency.getUSD("USD").enqueue(new Callback<Root1>() {
            @Override
            public void onResponse(Call<Root1> call, Response<Root1> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        System.out.println(response.body().result.lastupdate);
                        response.body().result.data.forEach(
                                item->{
                                    if (item.name.equals("Turkish Lira")){
                                        System.out.println(item.name);
                                        System.out.println(item.rate);
                                    }
                                }
                        );
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Root1> call, @NonNull Throwable t) {
                System.out.println("error USD:" + t.getLocalizedMessage());
            }
        });
        foreignCurrency.getUSD("EUR").enqueue(new Callback<Root1>() {
            @Override
            public void onResponse(Call<Root1> call, Response<Root1> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        System.out.println(response.body().result.lastupdate);
                        response.body().result.data.forEach(
                                item->{
                                    if (item.name.equals("Turkish Lira")){
                                        System.out.println(item.name);
                                        System.out.println(item.rate);
                                    }
                                }
                        );
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Root1> call, @NonNull Throwable t) {
                System.out.println("error USD:" + t.getLocalizedMessage());
            }
        });

    }
}
