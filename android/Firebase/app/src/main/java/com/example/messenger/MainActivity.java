package com.example.messenger;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;

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
        auth = FirebaseAuth.getInstance();
        //obtenemos usuario
        FirebaseUser user = auth.getCurrentUser();
        if (user == null){
            Log.d("MainActivity", "Not autorized");
        }else{
            Log.d("MainActivity", "Autorized");
        }
        //registramos nuevo usuario
        auth.createUserWithEmailAndPassword("email@email.com", "123456").addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                //obtenemos usuario
                FirebaseUser user = auth.getCurrentUser();
                if (user == null){
                    Log.d("MainActivity", "Not autorized");
                }else{
                    Log.d("MainActivity", "Autorized");
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("MainActivity", e.getMessage());
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        //Salir de la app
        auth.signOut();

        //E
        auth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //si usuario autorizado ->mostrr pantalla con todos los usuarios
                FirebaseUser user = auth.getCurrentUser();
                if (user == null){
                    Log.d("MainActivity", "Not autorized");
                }else{
                    Log.d("MainActivity", "Autorized");
                }
            }
        });


        //entrar en la app
        auth.signInWithEmailAndPassword("email@email.com", "123456").addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
               /*
                //obtenemos usuario
                FirebaseUser user = auth.getCurrentUser();
                if (user == null){
                    Log.d("MainActivity", "Not autorized");
                }else{
                    Log.d("MainActivity", "Autorized");
                }
                */
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("MainActivity", e.getMessage());
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}