package com.example.movies;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    private static final String BASE_URL = "https://api.kinopoisk.dev/v1.4/";


    private static final Retrofit retrofit = new Retrofit.Builder()//realizacion de Retrofin
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // Handles JSON conversion
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // Adds RxJava3 support
            .build();


//obtenemos ejemplar ApiService de realizacion de retrofit
public static final ApiService apiService = retrofit.create(ApiService.class);



}
