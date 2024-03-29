package com.example.usd_eur.View;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.usd_eur.Adapter.CurrentAdapter;
import com.example.usd_eur.Model.Data1;
import com.example.usd_eur.ViewModel.CurrentViewModel;
import com.example.usd_eur.databinding.FragmentCurrentBinding;
import java.util.ArrayList;
import java.util.List;

public class CurrentFragment extends Fragment {

    private FragmentCurrentBinding binding;

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

        currentViewModel.insertData(requireContext());

        direction();
    }

    private void direction(){

        NavDirections navDirections = CurrentFragmentDirections.actionCurrentFragmentToCalculateFragment();

        binding.floatingActionButton.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(navDirections);
        });
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
                System.out.println(data1s.size());
                if (data1s.size() > 0){
                    for (int i = 0; i < 8; i++){
                        data1ArrayList.add(data1s.get(i));
                        binding.progressBar.setVisibility(View.GONE);
                    }
                }else{
                    binding.progressBar.setVisibility(View.VISIBLE);
                    Toast.makeText(requireContext(), "List is empty", Toast.LENGTH_SHORT).show();
                    System.out.println("list empty");
                }
                initRecycler(data1ArrayList);
            }
        });
    }

    private void initRecycler(ArrayList<Data1> data1ArrayList){
         binding.recyclerView.setAdapter(new CurrentAdapter(data1ArrayList));
         binding.recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
    }
}