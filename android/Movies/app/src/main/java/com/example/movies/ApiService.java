package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("movie?token=CA4EP9E-R4F4XE7-J97X81W-V05R4WH&rating.kp=7-10&votes.kp=1000-6666666&page=2&limit=5")
    Single<MovieResponse> loadMovies();
}
