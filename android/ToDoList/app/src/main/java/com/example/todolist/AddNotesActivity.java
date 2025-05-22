package com.example.todolist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class AddNotesActivity extends AppCompatActivity {


    private EditText editTextAddNote;
    private RadioButton radioButtonLow;
    private RadioButton radioButtonMedium;
    private Button buttonSave;

    //private Database database = Database.getInstance();
    //private NoteDatabase noteDatabase;
    //private Handler handler = new Handler(Looper.getMainLooper());

    private AddNoteViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_notes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //noteDatabase = NoteDatabase.getInstance(getApplication());
        initViews();
        viewModel = new ViewModelProvider(this).get(AddNoteViewModel.class);
        viewModel.getShouldCloseScreen().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean shouldClose) {
                if(shouldClose){
                    finish();
                }
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();
            }
        });
    }

    private void initViews(){
        editTextAddNote = findViewById(R.id.editTextAddNote);
        radioButtonLow = findViewById(R.id.radioButtonLow);
        radioButtonMedium = findViewById(R.id.radioButtonMedium);
        buttonSave = findViewById(R.id.buttonSaveNote);
    }

    private void saveNote(){
        String text = editTextAddNote.getText().toString().trim();
        int priority = getPriority();
        //int id = database.getNotes().size();
        Note note = new Note(0, text, priority);
        viewModel.saveNote(note);
/*
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //database.add(note);
                noteDatabase.notesDao().add(note);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                });
            }
        });
        thread.start();

 */
    }

    private int getPriority(){
        int priority;
        if(radioButtonLow.isChecked()){
            priority = 0;
        }else if(radioButtonMedium.isChecked()){
            priority = 1;
        } else{
            priority = 2;
        }
        return priority;
    }

    public static Intent newIntent(Context context){
        return new Intent(context, AddNotesActivity.class);
    }
}