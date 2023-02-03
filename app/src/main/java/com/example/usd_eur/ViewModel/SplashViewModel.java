package com.example.usd_eur.ViewModel;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.example.usd_eur.Model.Data1;
import com.example.usd_eur.Model.Root1;
import com.example.usd_eur.Retrofit.ApiClient;
import com.example.usd_eur.Room.ForeignCurrencyDb;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashViewModel extends ViewModel {

    public void insertData(Context context){

        delete(context);

        ArrayList<String> money = new ArrayList<>();
        money.add("USD");
        money.add("EUR");
        money.add("GBP");
        money.add("RUB");
        money.add("BGN");

        getData(context, money);
    }

    private void getData(Context context, ArrayList<String> money){

        money.forEach(
            it->{
                ApiClient.getApi().getUSD(it).enqueue(new Callback<Root1>() {
                    @Override
                    public void onResponse(@NonNull Call<Root1> call, @NonNull Response<Root1> response) {
                        if (response.isSuccessful()){
                            if (response.body() != null){
                                response.body().getResult().getData().forEach(
                                    it->{
                                        if (it.getCode().equals("TRY")){
                                            insert(it, context);
                                        }
                                    }
                                );
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<Root1> call, @NonNull Throwable t) {
                        Log.e("error onFailure", t.getLocalizedMessage());
                    }
                });
            }
        );
    }

    private void insert(Data1 data1, Context context){

        ForeignCurrencyDb foreignCurrencyDb = ForeignCurrencyDb.getDatabase(context);

        ForeignCurrencyDb.databaseExecutor.execute(()->{
            foreignCurrencyDb.foreignCurrencyDao().insert(data1);
        });
    }

    public void delete(Context context){

        ForeignCurrencyDb foreignCurrencyDb = ForeignCurrencyDb.getDatabase(context);

        ForeignCurrencyDb.databaseExecutor.execute(()->{
            foreignCurrencyDb.foreignCurrencyDao().delete();
        });
    }
}