package com.example.movies;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class MainViewModel extends AndroidViewModel {

    //para cargar datos con RxJava vamos necesitar objeto de CompositeDisposable
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    private final MutableLiveData<List<Movie>> movies = new MutableLiveData<>();


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
