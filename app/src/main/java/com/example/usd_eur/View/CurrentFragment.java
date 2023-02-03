package com.example.usd_eur.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.usd_eur.Model.Data1;
import com.example.usd_eur.ViewModel.CurrentViewModel;
import com.example.usd_eur.ViewModel.SplashViewModel;
import com.example.usd_eur.databinding.FragmentCurrentBinding;

import java.util.List;

public class CurrentFragment extends Fragment {

    private FragmentCurrentBinding binding;

    private SplashViewModel viewModel;

    private CurrentViewModel currentViewModel;

    public CurrentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCurrentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        currentViewModel = new ViewModelProvider(requireActivity()).get(CurrentViewModel.class);

        //viewModel = new ViewModelProvider(requireActivity()).get(SplashViewModel.class);

        //viewModel.insertData(requireContext());
    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }

    private void getData(){
        currentViewModel.moneyData.observe(getViewLifecycleOwner(), new Observer<List<Data1>>() {
            @Override
            public void onChanged(List<Data1> data1s) {
                data1s.forEach(it->{
                    System.out.println(it.getName());
                    System.out.println(it.getCode());
                    System.out.println(it.getRate());
                    System.out.println(it.getName());
                });
            }
        });

        currentViewModel.getData(requireContext());
    }
}