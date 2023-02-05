package com.example.usd_eur.View;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.usd_eur.Model.Data1;
import com.example.usd_eur.ViewModel.CalculateViewModel;
import com.example.usd_eur.databinding.FragmentCalculateBinding;

import java.util.List;

public class CalculateFragment extends Fragment {

    private FragmentCalculateBinding binding;

    private CalculateViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCalculateBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(CalculateViewModel.class);

        viewModel.getRoomData(requireContext());

        getDolar();
    }

    private void getDolar(){

        viewModel.moneyData.observe(getViewLifecycleOwner(), new Observer<List<Data1>>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onChanged(List<Data1> data1s) {
                if (data1s.size() > 0){
                    btnClick(data1s.get(0).getRate());
                }else {
                    Toast.makeText(requireContext(), "List is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void btnClick(double dolar){

        binding.textDolar1.setText(dolar + "$");

        binding.dolarBtn.setOnClickListener(v ->{
            calculateDolar(dolar);
        });

        binding.turkBtn.setOnClickListener(v ->{
            calculateLira(dolar);
        });
    }

    private void calculateDolar(double dolar){

        String money = binding.editDolar.getText().toString().trim();

        if (!money.equals("")){

            double money1 = Double.parseDouble(money);

            binding.editDolar.setText("");

            binding.textDolar.setText(String.valueOf("Dolar: " + (money1 / dolar)));
        }
    }

    private void calculateLira(double lira){

        String money = binding.editTurk.getText().toString().trim();

        if (!money.equals("")){

            double money1 = Double.parseDouble(money);

            binding.editTurk.setText("");

            binding.textTurk.setText(String.valueOf("Lira: " + (money1 * lira)));
        }
    }
}