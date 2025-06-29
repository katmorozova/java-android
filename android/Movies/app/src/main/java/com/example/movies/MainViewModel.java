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
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

//collecion de peliculas
    private MutableLiveData<List<Movie>> movies = new MutableLiveData<>();
    //objeto liveData que guarda valor tipo boolean: va carga o no de las peliculas
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private int page = 1;

    public MainViewModel(@NonNull Application application) {
        super(application);
        loadMovies();
    }

    public LiveData<List<Movie>> getMovies() {
        return movies;
    }

    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    //metodo que va cargar datos y añadir en objeto movies
    public void loadMovies(){
        //obtenemos valor desde livedata
        Boolean loading = isLoading.getValue();
        //si la carga de los datos esta iniciadoc
        if(loading != null && loading){
            return;
        }
        Disposable disposable = ApiFactory.apiService.loadMovies(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //cuando comienza la garga de los datos insertamos valor true en objeto de liveData isLoading
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Throwable {
                        isLoading.setValue(true);
                    }
                })
                //cuando termina la garga de los datos insertamos valor false en objeto de liveData isLoading
                .doAfterTerminate(new Action() {
                    @Override
                    public void run() throws Throwable {
                        isLoading.setValue(false);
                    }
                })
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
                        Log.d("MainViewModel", "Loaded: "+page);
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
