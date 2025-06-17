package com.example.movies;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>{

    private List<Movie> movies = new ArrayList<>();
    private OnReachEndListener onReachEndListener;
    private OnMovieClickListener onMovieClickListener;


    public void setOnReachEndListener(OnReachEndListener onReachEndListener) {
        this.onReachEndListener = onReachEndListener;
    }

    public void setOnMovieClickListener(OnMovieClickListener onMovieClickListener) {
        this.onMovieClickListener = onMovieClickListener;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.movie_item,
                parent,
                false
        );
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Log.d("MoviesAdapter","onBindViewHolder: " + position);
        Movie movie = movies.get(position);
        Glide.with(holder.itemView)
                .load(movie.getPoster().getUrl())
                .into(holder.imageViewPoster);

        //obtenemos rating
        double rating = movie.getRating().getKp();
        //obtenemos id drawable archivo
        int backgroundId;
        if(rating > 7){
            backgroundId = R.drawable.circle_green;
        }else if(rating > 5){
            backgroundId = R.drawable.circle_orange;
        }else{
            backgroundId = R.drawable.circle_red;
        }
        //obtenemos background
        Drawable background = ContextCompat.getDrawable(holder.itemView.getContext(), backgroundId);
        //insertamos background en textViewRating
        holder.textViewRating.setBackground(background);
        holder.textViewRating.setText(String.valueOf(rating));

        if(position >= movies.size() - 10 && onReachEndListener != null){
            onReachEndListener.onReachEnd();
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onMovieClickListener != null){
                    onMovieClickListener.onMovieClick(movie);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    //callback para reacionar a un scroll hasta final de la pantalla
    interface OnReachEndListener{
        void onReachEnd();
    }
//callback para reaccionar a un click sobre una lista de las peliculas
    interface OnMovieClickListener{
        void onMovieClick(Movie movie);
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewPoster;
        private TextView textViewRating;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPoster = itemView.findViewById(R.id.imageViewPoster);
            textViewRating = itemView.findViewById(R.id.textViewRating);
        }
    }
}
