package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    //@GET("movie?token=CA4EP9E-R4F4XE7-J97X81W-V05R4WH&rating.kp=7-10&votes.kp=1000-6666666&limit=5")
    @GET("movie?token=CA4EP9E-R4F4XE7-J97X81W-V05R4WH&rating.kp=4-8&votes.kp=1000-6666666&limit=30")
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @GET("movie?page=1&limit=30&token=CA4EP9E-R4F4XE7-J97X81W-V05R4WH&notNullFields=videos.trailers.url&selectFields=id&selectFields=videos")
    Single<TrailerResponse> loadTrailers(@Query("id")int id);
}
