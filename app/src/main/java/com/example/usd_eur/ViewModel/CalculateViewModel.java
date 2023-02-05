package com.example.usd_eur.ViewModel;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.usd_eur.Model.Data1;
import com.example.usd_eur.Room.ForeignCurrencyDb;
import java.util.List;

public class CalculateViewModel extends ViewModel {

    public MutableLiveData<List<Data1>> moneyData = new MutableLiveData<>();

    public void getRoomData(Context context){

        ForeignCurrencyDb foreignCurrencyDb = ForeignCurrencyDb.getDatabase(context);

        ForeignCurrencyDb.databaseExecutor.execute(()->{
            if (foreignCurrencyDb.foreignCurrencyDao().getAllMoney().size() > 0){
                moneyData.postValue(foreignCurrencyDb.foreignCurrencyDao().getAllMoney());
            }else {
                System.out.println("CalculateViewModel list empty");
            }
        });
    }
}
