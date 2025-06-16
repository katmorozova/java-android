package com.example.movies;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

//collecion de peliculas
    private MutableLiveData<List<Movie>> movies = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private int page = 1;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Movie>> getMovies() {
        return movies;
    }

    //metodo que va cargar datos y añadir en objeto movies
    public void loadMovies(){
        Disposable disposable = ApiFactory.apiService.loadMovies(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MovieResponse>() {
                    @Override
                    public void accept(MovieResponse movieResponse) throws Throwable {
                        //Obtenemos la peliculas cargadas antes
                        List<Movie> loadedMovies = movies.getValue();
                        if(loadedMovies != null){
                            loadedMovies.addAll(movieResponse.getMovies());
                        //añadimos nueva collecion de pelis en livedata
                            movies.setValue(loadedMovies);
                        }else{
                            movies.setValue(movieResponse.getMovies());
                        }
                        page++;
                        //aqui nos llega la collecion de peliculas, les necesitamos añadir dentro de LiveData
                        //movies.setValue(movieResponse.getMovies());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.d("MainViewModel", throwable.toString());
                    }
                });
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
