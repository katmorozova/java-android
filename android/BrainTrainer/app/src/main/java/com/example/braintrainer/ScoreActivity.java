package com.example.braintrainer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScoreActivity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewResult = findViewById(R.id.textViewResult);
        Intent intent = getIntent(); //obtenemos Intent
        if(intent != null && intent.hasExtra("result")){//realizamos comprobacion
            int result = intent.getIntExtra("result", 0);//obtenemos resultado
            String score = String.format("Vuestro resultado: %s", result);//linea con resultado
            textViewResult.setText(score);//añadimos texto en textViewResult
        }
    }

    public void onClickStartNewGame(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}