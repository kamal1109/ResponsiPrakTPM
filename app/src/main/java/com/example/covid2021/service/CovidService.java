package com.example.covid2021.service;

import com.example.covid2021.model.faskes.Data_faskes;
import com.example.covid2021.model.faskes.Respon_faskes;
import com.example.covid2021.model.accident.Kasus_Item;
import com.example.covid2021.model.accident.KasusResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CovidService {
    private Retrofit retrofit = null;

    public CovidAPI getAPI(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(CovidAPI.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(CovidAPI.class);
    }

    public void getKasus(final CovidListener<List<Kasus_Item>> listener){
        getAPI().getCoronaCase().enqueue(new Callback<KasusResponse>() {
            @Override
            public void onResponse(Call<KasusResponse> call, Response<KasusResponse> response) {
                KasusResponse data = response.body();

                if (data != null && data.getData() != null){
                    listener.onSuccess(data.getData().getContent());
                }
            }

            @Override
            public void onFailure(Call<KasusResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

    public void getFaskes(final CovidListener<List<Data_faskes>> listener){
        getAPI().getFaskes().enqueue(new Callback<Respon_faskes>() {
            @Override
            public void onResponse(Call<Respon_faskes> call, Response<Respon_faskes> response) {
                Respon_faskes data = response.body();

                if (data != null && data.getData() != null){
                    listener.onSuccess(data.getData());
                }
            }

            @Override
            public void onFailure(Call<Respon_faskes> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }
}
