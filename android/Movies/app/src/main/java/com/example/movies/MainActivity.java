package com.example.movies;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    private MoviesAdapter moviesAdapter;
    private RecyclerView recyclerViewMovies;
    private ProgressBar progressBarLoading;

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
/*
        Intent intent = FavouriteMovieActivity.newIntent(this);
        startActivity(intent);

 */

        progressBarLoading = findViewById(R.id.progressBarLoading);
        recyclerViewMovies = findViewById(R.id.recyclerViewMovies);
        //Creamos adapter
        moviesAdapter = new MoviesAdapter();
        //Insertamos adapter en recyclerView
        recyclerViewMovies.setAdapter(moviesAdapter);
        recyclerViewMovies.setLayoutManager(new GridLayoutManager(this,2 ));

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getMovies().observe(this, new Observer<List<Movie>>() {
        @Override
        public void onChanged(List<Movie> movies) {
//en caso de exito mostrar en pantalla
            Log.d("MainActivity", movies.toString());
            //añadir movies en adapter
            moviesAdapter.setMovies(movies);
        }
    });
    //viewModel.loadMovies();
    //Suscribimos en objeto de liveData isLoading para mostrar progressBar
    viewModel.getIsLoading().observe(this, new Observer<Boolean>() {
        @Override
        public void onChanged(Boolean isLoading) {
            if(isLoading){
                progressBarLoading.setVisibility(View.VISIBLE);
            }else{
                progressBarLoading.setVisibility(View.GONE);
            }
        }
    });
    moviesAdapter.setOnReachEndListener(new MoviesAdapter.OnReachEndListener() {
        @Override
        public void onReachEnd() {
            //arrancamos nueva carga de las peliculas
            viewModel.loadMovies();
        }
    });
    //Añadimos evento setOnMovieAdapter() para MovieAdapter
        moviesAdapter.setOnMovieClickListener(new MoviesAdapter.OnMovieClickListener() {
            @Override
            public void onMovieClick(Movie movie) {
                Intent intent = MovieDetailActivity.newIntent(MainActivity.this, movie);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //obtenemos ejemplar de clase MenuInflator
        getMenuInflater().inflate(R.menu.main_menu, menu);//se muestra menu en la pantalla
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.itemFavourite){
            Intent intent = FavouriteMovieActivity.newIntent(this);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}