package com.example.usd_eur.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usd_eur.Adapter.CurrentAdapter;
import com.example.usd_eur.Model.Data1;
import com.example.usd_eur.Utils.MoneyCode;
import com.example.usd_eur.ViewModel.CurrentViewModel;
import com.example.usd_eur.ViewModel.SplashViewModel;
import com.example.usd_eur.databinding.FragmentCurrentBinding;

import java.util.ArrayList;
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

        //currentViewModel.insertData(requireContext());

    }

    @Override
    public void onResume() {
        super.onResume();

        getData();
    }

    private void getData(){

        currentViewModel.getRoomData(requireContext());

        currentViewModel.moneyData.observe(getViewLifecycleOwner(), new Observer<List<Data1>>() {
            @Override
            public void onChanged(List<Data1> data1s) {

                ArrayList<Data1> data1ArrayList = new ArrayList<>(data1s);
                data1ArrayList.clear();
                for (int i = 0; i < 6; i++){
                    data1ArrayList.add(data1s.get(i));
                }
                initRecycler(data1ArrayList);
            }
        });
    }

    private void initRecycler(ArrayList<Data1> data1ArrayList){
         binding.recyclerView.setAdapter(new CurrentAdapter(data1ArrayList, MoneyCode.getMoneyCode(), MoneyCode.getMoneyName()));
         binding.recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
    }
}