package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiService {

    @GET("movie?token=CA4EP9E-R4F4XE7-J97X81W-V05R4WH&rating.kp=7-10&sortField=votes.kp&sortType=-1&notNullFields=videos.trailers.url&notNullFields=poster.url&limit=30")
    //@GET("movie?token=CA4EP9E-R4F4XE7-J97X81W-V05R4WH&rating.kp=4-8&sortField=votes.kp&sortType=-1&notNullFields=videos.trailers.url&notNullFields=poster.url&limit=100")
    Single<MovieResponse> loadMovies(@Query("page")int page);

}
