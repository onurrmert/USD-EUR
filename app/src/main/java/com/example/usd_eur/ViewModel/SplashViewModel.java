package com.example.usd_eur.ViewModel;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.example.usd_eur.Model.Data1;
import com.example.usd_eur.Model.Root1;
import com.example.usd_eur.Retrofit.ApiClient;
import com.example.usd_eur.Room.ForeignCurrencyDb;
import com.example.usd_eur.Utils.MoneyCode;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashViewModel extends ViewModel {

    public void delete(Context context){

        ForeignCurrencyDb foreignCurrencyDb = ForeignCurrencyDb.getDatabase(context);

        ForeignCurrencyDb.databaseExecutor.execute(()->{
            foreignCurrencyDb.foreignCurrencyDao().delete();
        });
    }
}