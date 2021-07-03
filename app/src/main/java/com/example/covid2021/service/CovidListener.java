package com.example.covid2021.service;

public interface CovidListener<T> {
    void onSuccess(T items);
    void onFailed(String msg);
}
