package com.example.nilay.movieapp.api;

import com.example.nilay.movieapp.model.MovieList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    /**
     * Call for get popular movies
     * @param apiKey API Key for The Movie Database
     * @return popular movies as list
     */
    @GET("movie/popular")
    Call<MovieList> getPopularMovies(@Query("api_key") String apiKey);

    /**
     * Call for top-rated movies
     * @param apiKey API Key for The Movie Database
     * @return top-rated movies as list
     */
    @GET("movie/top_rated")
    Call<MovieList> getTopRatedMovies(@Query("api_key") String apiKey);
}
