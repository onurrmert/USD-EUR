package com.example.usd_eur;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.usd_eur.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}