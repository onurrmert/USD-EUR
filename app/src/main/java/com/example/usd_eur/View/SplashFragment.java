package com.example.usd_eur.View;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usd_eur.R;
import com.example.usd_eur.ViewModel.SplashViewModel;
import com.example.usd_eur.databinding.FragmentSplashBinding;

public class SplashFragment extends Fragment {

    private FragmentSplashBinding binding;

    private SplashViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //viewModel = new ViewModelProvider(requireActivity()).get(SplashViewModel.class);

        //viewModel.insertData(requireContext());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                direction();
            }
        }, 1200);
    }


    private void direction(){
        NavDirections navDirections = SplashFragmentDirections.actionSplashFragmentToCurrentFragment();
        Navigation.findNavController(requireView()).navigate(navDirections);
    }
}