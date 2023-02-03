package com.example.usd_eur.Room;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.usd_eur.Model.Data1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Data1.class}, version = 3, exportSchema = false)
public abstract class ForeignCurrencyDb extends RoomDatabase {

    public abstract IForeignCurrencyDao foreignCurrencyDao();

    public static volatile ForeignCurrencyDb INSTANCE;

    public static final int NUMBERTHREAD = 8;

    public static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBERTHREAD);

    public static ForeignCurrencyDb getDatabase(Context context){

        if (INSTANCE == null){
            synchronized (ForeignCurrencyDb.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                                    context,
                                    ForeignCurrencyDb.class,
                                    "foreignCurrencyDb")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
