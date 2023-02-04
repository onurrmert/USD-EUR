package com.example.usd_eur.Retrofit;

import com.example.usd_eur.Model.Root1;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface IForeignCurrency {

    @GET("economy/currencyToAll?int=10&")
    @Headers("authorization: apikey 59mrULyhBYIIF0DwN888ne:4X6sAZvGrB3VDszXhm7voJ")
    Call<Root1> getUSD(@Query("base") String base);
}
