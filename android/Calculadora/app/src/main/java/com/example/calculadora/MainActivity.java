package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        EditText editTextNumber = findViewById(R.id.editTextNumber);
        Button buttonAnswer = findViewById(R.id.buttonAnswer);
        TextView textViewAnswerIncorrect = findViewById(R.id.textViewAnswerIncorrect);
        TextView textViewAnswerCorrect = findViewById(R.id.textViewAnswerCorrect);
        TextView textViewExample = findViewById(R.id.textViewExample);

        textViewExample.setText("10 + 20 = ?");

        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editTextNumber.getText().toString();
                int number = Integer.parseInt(text);
                if(number == 30){
                    textViewAnswerCorrect.setVisibility(View.VISIBLE);
                    textViewAnswerIncorrect.setVisibility(View.GONE);
                }else{
                    textViewAnswerCorrect.setVisibility(View.GONE);
                    textViewAnswerIncorrect.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}