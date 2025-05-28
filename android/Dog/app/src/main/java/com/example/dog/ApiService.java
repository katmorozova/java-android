package com.example.dog;

import io.reactivex.rxjava3.core.Single;

public interface ApiService {


    Single<DogImage> loadDogImage();
}
