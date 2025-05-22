package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    private FloatingActionButton buttonAddNote;
    private NotesAdapter notesAdapter;

    //private Database database = Database.getInstance();
    //private NoteDatabase noteDatabase;

    //private Handler handler = new Handler(Looper.getMainLooper());
    private MainViewModel viewModel;

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
        //noteDatabase = noteDatabase.getInstance(getApplication());
        initViews();
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        notesAdapter = new NotesAdapter();
        notesAdapter.setOnNoteClickListener(new NotesAdapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(Note note) {
                //database.remove(note.getId());
                //showNotes();


            }
        });

        recyclerViewNotes.setAdapter(notesAdapter);

        viewModel.getNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                notesAdapter.setNotes(notes);
            }
        });
/*
        noteDatabase.notesDao().getNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                notesAdapter.setNotes(notes);
            }
        });

 */


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
            0,ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT
        ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target
            ) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                Note note = notesAdapter.getNotes().get(position);
                viewModel.remove(note);
                //database.remove(note.getId());
/*
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        noteDatabase.notesDao().remove(note.getId());

                       // handler.post(new Runnable() {
                        //    @Override
                          //  public void run() {
                          //      showNotes();
                          //  }
                        //});
                    }
                });
                thread.start();
*/
            }
        });

        itemTouchHelper.attachToRecyclerView(recyclerViewNotes);

        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNotesActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }
/*
    @Override
    protected void onResume() {
        super.onResume();
        showNotes();
    }

 */

    private void initViews(){
        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
        buttonAddNote = findViewById(R.id.buttonAddNote);
    }
/*
    private void showNotes(){
        //notesAdapter.setNotes(database.getNotes());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                List<Note> notes = noteDatabase.notesDao().getNotes();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        notesAdapter.setNotes(notes);
                    }
                });

            }
        });
        thread.start();
    }
 */

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.refreshList();
    }
}
