package com.example.dog;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static String BASE_URL = "https://dog.ceo/api/breeds/image/random";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadDogImage();
    }


    private void loadDogImage(){
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

                    Log.d("MainActivity", data.toString());

                } catch (Exception e) {
                    Log.d("MainActivity", e.toString());
                }
            }
        }).start();
    }
}