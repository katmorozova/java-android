package com.example.dog;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

import io.reactivex.rxjava3.core.Single;

public class MainViewModel extends AndroidViewModel {

    private static final String BASE_URL = "https://dog.ceo/api/breeds/image/random";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_STATUS = "status";
    private static final String TAG = "MainViewModel";

    private MutableLiveData<DogImage> dogImage = new MutableLiveData<>();

    public MainViewModel(@NonNull Application application){
        super(application);
    }

    public LiveData<DogImage> getDogImage() {
        return dogImage;
    }

    public void loadDogImage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(BASE_URL);//crear objeto url
                    HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                    InputStream inputStream = urlConnection.getInputStream();//leer datos desde internet
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);//leer datos como simbolos
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//leer datos por linea
                    StringBuilder data = new StringBuilder();
                    String result;
                    do{
                        result = bufferedReader.readLine();//devuelve en una linea
                        if(result != null){
                            data.append(result);
                        }
                    }while (result != null);
                    JSONObject jsonObject = new JSONObject(data.toString());
                    String message = jsonObject.getString(KEY_MESSAGE);
                    String status = jsonObject.getString(KEY_STATUS);
                    DogImage image = new DogImage(message, status);
                    dogImage.postValue(image);
                    //Log.d(TAG, dogImage.toString());

                } catch (Exception e) {
                    Log.d(TAG, e.toString());
                }
            }
        }).start();
    }

    private Single<DogImage> loadDogImageRx(){
        return Single.fromCallable(new Callable<DogImage>() {
            @Override
            public DogImage call() throws Exception {
                    URL url = new URL(BASE_URL);//crear objeto url
                    HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                    InputStream inputStream = urlConnection.getInputStream();//leer datos desde internet
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);//leer datos como simbolos
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//leer datos por linea
                    StringBuilder data = new StringBuilder();
                    String result;
                    do{
                        result = bufferedReader.readLine();//devuelve en una linea
                        if(result != null){
                            data.append(result);
                        }
                    }while (result != null);
                    JSONObject jsonObject = new JSONObject(data.toString());
                    String message = jsonObject.getString(KEY_MESSAGE);
                    String status = jsonObject.getString(KEY_STATUS);
                    return new DogImage(message, status);

            }
        });
    }

}
