package com.example.braintrainer;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTimer;
    private TextView textViewScore;
    private TextView textViewQuestion;
    private TextView textViewAnswer1;
    private TextView textViewAnswer2;
    private TextView textViewAnswer3;
    private TextView textViewAnswer4;

    private ArrayList<TextView> options = new ArrayList<>();

    private String question;
    private int rightAnswer;
    private int rightAnswerPosition;
    private boolean isPositive;
    private int min = 5;
    private int max = 30;

    private int countOfQuestions = 0;
    private int countOfRightAnswers = 0;


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
        initViews();
        options.add(textViewAnswer1);
        options.add(textViewAnswer2);
        options.add(textViewAnswer3);
        options.add(textViewAnswer4);
        playNext();

        CountDownTimer timer = new CountDownTimer(6000, 1000) {
            @Override
            public void onFinish() {

            }

            @Override
            public void onTick(long millisUntilFinished) {
                textViewTimer.setText(getTime(millisUntilFinished));
            }
        };
        timer.start();

    }

    private void playNext(){
        generateQuestion();
        for(int i = 0; i<options.size(); i++){
            if (i == rightAnswerPosition){
                options.get(i).setText(Integer.toString(rightAnswer));
            } else {
                options.get(i).setText(Integer.toString(generateWrongAnswer()));
            }
        }
        String score = String.format("%s / %s", countOfRightAnswers, countOfQuestions);
        textViewScore.setText(score);
    }

    private void initViews(){
        textViewTimer = findViewById(R.id.textViewTimer);
        textViewScore = findViewById(R.id.textViewScore);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewAnswer1 = findViewById(R.id.textViewAnswer1);
        textViewAnswer2 = findViewById(R.id.textViewAnswer2);
        textViewAnswer3 = findViewById(R.id.textViewAnswer3);
        textViewAnswer4 = findViewById(R.id.textViewAnswer4);

    }

    private void generateQuestion(){
        int a = (int) (Math.random() * (max - min +1) + min);
        int b = (int) (Math.random() * (max - min +1) + min);
        int mark = (int) (Math.random() * 2);
        isPositive = mark == 1;
        if(isPositive){
            rightAnswer = a + b;
            question = String.format("%s + %s", a, b);
        } else {
            rightAnswer = a - b;
            question = String.format("%s - %s", a, b);
        }
        textViewQuestion.setText(question);
        rightAnswerPosition = (int) (Math.random() * 4);
    }

    private int generateWrongAnswer(){
        int result;
        do {
            result = (int) (Math.random() * max * 2 + 1) - (max - min);
        } while(result == rightAnswer);
        return result;
    }

    private String getTime(long millis){
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
    }

    public void onClickAnswer(View view) {
        TextView textView = (TextView) view;
        String answer = textView.getText().toString();
        int chosenAnswer = Integer.parseInt(answer);
        if (chosenAnswer == rightAnswer){
            countOfRightAnswers++;
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
        }
        countOfQuestions++;
        playNext();
    }
}