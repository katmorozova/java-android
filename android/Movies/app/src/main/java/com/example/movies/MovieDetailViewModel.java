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

public class MovieDetailViewModel extends AndroidViewModel {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<Trailer>> trailers = new MutableLiveData<>();

    public MovieDetailViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Trailer>> getTrailers() {
        return trailers;
    }

    public void loadTrailers(int id){
        //enviamos peticion para cargar los trailers
        Disposable disposable = ApiFactory.apiService.loadTrailers(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TrailerResponse>() {
                    @Override
                    public void accept(TrailerResponse trailerResponse) throws Throwable {
                        Log.d("MovieDetailViewModel", trailerResponse.toString());
                        //Obtenemos peliculas desde trailersResponse y insertamos en liveData
                        trailers.setValue(trailerResponse.getTrailersList().getTrailers());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.d("MovieDetailViewModel",throwable.toString() );
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
