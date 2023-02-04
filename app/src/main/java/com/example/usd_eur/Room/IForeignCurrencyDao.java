package com.example.usd_eur.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.usd_eur.Model.Data1;
import java.util.List;

@Dao
public interface IForeignCurrencyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Data1 data1);

    @Query("SELECT * FROM foreignCurrencyTable")
    List<Data1> getAllMoney();

    @Query("DELETE FROM foreignCurrencyTable")
    void delete();
}
