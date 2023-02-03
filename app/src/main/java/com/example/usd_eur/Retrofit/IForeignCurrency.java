package com.example.usd_eur.Retrofit;

import com.example.usd_eur.Model.Root1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface IForeignCurrency {

    //"https://api.collectapi.com/economy/currencyToAll?int=10&base=USD"
    @GET("economy/currencyToAll?int=10&")
    @Headers("authorization:apikey 4TxjZiIgMlNtChq1aTTT8y:77ArgvxSOkqkcs47CLuyw3")
    Call<Root1> getUSD(@Query("base") String base);
}
