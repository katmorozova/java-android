package com.example.dog;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainViewModel extends AndroidViewModel {

    private static final String BASE_URL = "https://dog.ceo/api/breeds/image/random";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_STATUS = "status";
    private static final String TAG = "MainViewModel";

    public MainViewModel(@NonNull Application application){
        super(application);
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
                    DogImage dogImage = new DogImage(message, status);

                    Log.d(TAG, dogImage.toString());

                } catch (Exception e) {
                    Log.d(TAG, e.toString());
                }
            }
        }).start();
    }

}
