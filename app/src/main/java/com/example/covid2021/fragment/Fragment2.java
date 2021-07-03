package com.example.covid2021.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.covid2021.R;
import com.example.covid2021.adapter.FaskesAdapter;
import com.example.covid2021.model.faskes.Data_faskes;
import com.example.covid2021.service.CovidListener;
import com.example.covid2021.service.CovidService;

import java.util.List;

public class Fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_r_s, container, false);
    }

    RecyclerView rvRecyclerView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvRecyclerView = view.findViewById(R.id.rv_rs);
        new CovidService().getFaskes(covidListener);
    }

    CovidListener<List<Data_faskes>> covidListener = new CovidListener<List<Data_faskes>>() {

        @Override
        public void onSuccess(List<Data_faskes> items) {

            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rvRecyclerView.setLayoutManager(linearLayoutManager);
            FaskesAdapter rvAdapter = new FaskesAdapter(items);
            rvRecyclerView.setAdapter(rvAdapter);

            for(int i = 0; i < items.size(); i++){
                Log.d("Hasilnya : ", String.valueOf(items.get(i).getNama()));
            }
        }

        @Override
        public void onFailed(String msg) {
            Log.d("Errornya : ", msg);
        }
    };
}