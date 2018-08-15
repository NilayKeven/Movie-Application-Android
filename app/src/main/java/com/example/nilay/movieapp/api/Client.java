package com.example.nilay.movieapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    /**
     * BASE_URL of The Movie Database
     */
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    /**
     * Retrofit is a REST Client for Android. It makes it relatively easy to retrieve
     * and upload JSON via a REST based webservice.
     */
    public static Retrofit retrofit = null;

    /**
     * Add converter factory for serialization and deserialization of objects.
     * @return
     */
    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
