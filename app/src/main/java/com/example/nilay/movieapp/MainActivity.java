package com.example.nilay.movieapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.nilay.movieapp.adapter.MovieAdapter;
import com.example.nilay.movieapp.model.Movie;
import com.example.nilay.movieapp.model.MovieList;
import com.example.nilay.movieapp.api.Client;
import com.example.nilay.movieapp.api.Service;

import java.util.Collections;
import java.util.Comparator;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    protected MovieList movieList;
    private static final String API_KEY = "237707e7043bffb50a87e74f70a02e4b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_movie_list);

        Service service = Client.getClient().create(Service.class);
        retrofit2.Call<MovieList> call = service.getPopularMovies(API_KEY);

        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(retrofit2.Call<MovieList> call, Response<MovieList> response) {
                Log.i("URL: ", response.toString());
                movieList = response.body();
                recyclerView.setAdapter(new MovieAdapter(movieList.getMovieArrayList(), MainActivity.this));
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(retrofit2.Call<MovieList> call, Throwable t) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setMessage("Oops something went wrong. Please check your network connection!");
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    /**
     * Inflate menu resource into menu
     * @param menu menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Triggered when the item is selected in the menu. Sort by release date
     * @param menuItem item in the menu
     * @return When you successfully handle a menu item, return true
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        Collections.sort(movieList.getMovieArrayList(), new Comparator<Movie>() {
            public int compare(Movie o1, Movie o2) {
                if (o1.getRelease() == null || o2.getRelease() == null)
                    return 0;
                return o1.getRelease().compareTo(o2.getRelease());
            }
        });
        recyclerView.setAdapter(new MovieAdapter(movieList.getMovieArrayList(), MainActivity.this));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        return true;
    }
}
