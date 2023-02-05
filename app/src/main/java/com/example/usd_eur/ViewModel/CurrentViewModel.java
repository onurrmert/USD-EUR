package com.example.usd_eur.ViewModel;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.usd_eur.Model.Data1;
import com.example.usd_eur.Model.Root1;
import com.example.usd_eur.Retrofit.ApiClient;
import com.example.usd_eur.Room.ForeignCurrencyDb;
import com.example.usd_eur.Utils.MoneyCode;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrentViewModel extends ViewModel {

    public MutableLiveData<List<Data1>> moneyData = new MutableLiveData<>();

    public void insertData(Context context){
        getData(context, MoneyCode.getMoneyCode());
    }

    private void getData(Context context, ArrayList<String> money){

        money.forEach(
            it->{
                ApiClient.getApi().getUSD(it).enqueue(new Callback<Root1>() {
                    @Override
                    public void onResponse(@NonNull Call<Root1> call, @NonNull Response<Root1> response) {
                        if (response.isSuccessful()){
                            if (response.body() != null){
                                if (response.body().getResult().getData().size() > 0){
                                    response.body().getResult().getData().forEach(
                                        it->{
                                            if (it.getCode().equals("TRY")){
                                                insert(it, context);
                                                System.out.println("currentVM data add: " + it.getRate());
                                            }
                                        }
                                    );
                                }
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

    public void getRoomData(Context context){

        ForeignCurrencyDb foreignCurrencyDb = ForeignCurrencyDb.getDatabase(context);

        ForeignCurrencyDb.databaseExecutor.execute(()->{
            moneyData.postValue(foreignCurrencyDb.foreignCurrencyDao().getAllMoney());
        });
    }
}
