package com.example.todolist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainViewModel extends AndroidViewModel {


    private NoteDatabase noteDatabase;

    public MainViewModel(@NonNull Application application){
        super(application);
        noteDatabase = NoteDatabase.getInstance(application);
    }

    public void remove(Note note){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                noteDatabase.notesDao().remove(note.getId());
            }
        });
        thread.start();
    }
}
