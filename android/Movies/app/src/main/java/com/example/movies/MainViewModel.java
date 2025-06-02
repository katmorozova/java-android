package com.example.movies;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<List<Movie>> movies = new MutableLiveData<>();


    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Movie>> getMovies() {
        return movies;
    }


    //metodo que va cargar los datos y insertarles en objeto de movies
    public void loadMovies(){

    }
}
