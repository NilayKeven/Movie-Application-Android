package com.example.nilay.movieapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nilay.movieapp.R;
import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends Activity {
    protected TextView movie_title, movie_original_title, movie_vote_average, movie_release_date, movie_overview;
    protected ImageView movie_poster;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);
        Intent intent = getIntent();

        movie_title = findViewById(R.id.movie_title_detail);
        movie_original_title = findViewById(R.id.movie_original_title_detail);
        movie_vote_average = findViewById(R.id.movie_voteA_detail);
        movie_release_date = findViewById(R.id.movie_release_detail);
        movie_overview = findViewById(R.id.movie_overview_detail);
        movie_poster = findViewById(R.id.movie_poster_detail);

        movie_title.setText(intent.getStringExtra("movie_title"));
        movie_original_title.setText(intent.getStringExtra("movie_original_title"));
        movie_vote_average.setText(intent.getStringExtra("movie_vote_average"));
        movie_release_date.setText(intent.getStringExtra("movie_release_date"));
        movie_overview.setText(intent.getStringExtra("movie_overview"));
        Picasso.get().load(intent.getStringExtra("movie_poster_path")).into(movie_poster);
    }
}
