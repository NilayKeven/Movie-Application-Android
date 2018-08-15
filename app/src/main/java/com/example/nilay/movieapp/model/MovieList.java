package com.example.nilay.movieapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieList {
    /**
     * ArrayList for movie list
     */
    @SerializedName("results")
    private ArrayList<Movie> movieArrayList;

    /**
     * Getter for movie list
     * @return movie list
     */
    public ArrayList<Movie> getMovieArrayList(){
        return movieArrayList;
    }

    /**
     * Setter for movie lies
     * @param movieArrayList movie list
     */
    public void setMovieArrayList(ArrayList<Movie> movieArrayList){
        this.movieArrayList = movieArrayList;
    }
}
