package com.example.usd_eur.ViewModel;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.usd_eur.Model.Data1;
import com.example.usd_eur.Room.ForeignCurrencyDb;

import java.util.List;

public class CurrentViewModel extends ViewModel {

    public MutableLiveData<List<Data1>> moneyData = new MutableLiveData<>();

    public void getData(Context context){

        ForeignCurrencyDb foreignCurrencyDb = ForeignCurrencyDb.getDatabase(context);

        ForeignCurrencyDb.databaseExecutor.execute(()->{
            moneyData.postValue(foreignCurrencyDb.foreignCurrencyDao().getAllMoney());
        });
    }
}
