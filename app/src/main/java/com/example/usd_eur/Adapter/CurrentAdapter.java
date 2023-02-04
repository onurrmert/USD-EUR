package com.example.usd_eur.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.usd_eur.Model.Data1;
import com.example.usd_eur.R;
import com.example.usd_eur.Utils.MoneyCode;
import com.example.usd_eur.databinding.RecyclerRowsBinding;

import java.util.ArrayList;

public class CurrentAdapter extends RecyclerView.Adapter<CurrentAdapter.CurrentViewHolder>{

    private final ArrayList<Data1> moneyList;

    private final ArrayList<String> moneyCode;

    private final ArrayList<String> moneyName;

    public CurrentAdapter(ArrayList<Data1> data1s, ArrayList<String> moneyCode, ArrayList<String> moneyName){
        this.moneyList = data1s;
        this.moneyCode = moneyCode;
        this.moneyName = moneyName;
    }

    static class CurrentViewHolder extends RecyclerView.ViewHolder {
        public RecyclerRowsBinding binding = RecyclerRowsBinding.bind(this.itemView);

        public CurrentViewHolder(View itemView){
            super(itemView);
        }
    }

    @NonNull
    @Override
    public CurrentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflater = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_rows, parent, false);

        return new CurrentViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentViewHolder holder, int position) {

        if (!String.valueOf(this.moneyList.get(position).getRate()).equals("")){
            holder.binding.rate.setText(String.valueOf(this.moneyList.get(position).getRate()));
        }else {
            holder.binding.rate.setText("unknown");
        }
        if (!moneyName.get(position).equals("")){
            holder.binding.name.setText(moneyName.get(position));
        }
        if (!moneyCode.get(position).equals("")){
            holder.binding.code.setText(moneyCode.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return this.moneyList.size();
    }
}
