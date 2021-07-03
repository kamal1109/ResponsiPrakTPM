package com.example.covid2021.service;

import com.example.covid2021.model.faskes.Respon_faskes;
import com.example.covid2021.model.accident.KasusResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidAPI {
    String URL_BASE = "https://covid19-public.digitalservice.id/api/v1/";

    @GET("rekapitulasi_v2/jabar/harian")
    Call<KasusResponse> getCoronaCase();

    @GET("sebaran_v2/jabar/faskes")
    Call<Respon_faskes> getFaskes();

}
