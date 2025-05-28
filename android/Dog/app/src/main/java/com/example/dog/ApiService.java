package com.example.dog;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("random") //annotacion para obtener datos de la red
    Single<DogImage> loadDogImage();
}
