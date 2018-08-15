package com.example.nilay.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilay.movieapp.MovieDetailsActivity;
import com.example.nilay.movieapp.R;
import com.example.nilay.movieapp.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Implements a custom adapter as MovieAdapter, it extends RecyclerView.Adapter
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private ArrayList<Movie> movies;
    private Context context;

    /**
     * Constructor of MovieAdapter
     * @param movies List of movies
     * @param context context
     */
    public MovieAdapter(ArrayList<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    /**
     * This method is called to initialize the ViewHolder we created when the adapter was created.
     * @param parent parent
     * @param viewType type of view(support multiple view type forRecyclerView)
     * @return a ViewHolder for movie
     */
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Instantiates a layout XML file into its corresponding View objects.
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_row_view, parent, false);
        return new MovieViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position
     * @param holder ViewHolder for Movie
     * @param position position of data
     */
    @Override
    public void onBindViewHolder(MovieAdapter.MovieViewHolder holder, int position) {
        final Movie movie = movies.get(position);
        holder.movie_title.setText(movie.getTitle());
        holder.movie_vote_average.setText(movie.getVoteAverage().toString());
        holder.movie_release_date.setText(movie.getReleaseDate());
        Picasso.get().load(movie.getPosterPath()).into(holder.movie_poster);
        // Layout set as clikable to show the details of movie
        holder.movie_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MovieDetailsActivity.class);
                intent.putExtra("movie_title", movie.getTitle());
                intent.putExtra("movie_original_title", movie.getOriginalTitle());
                intent.putExtra("movie_poster_path", movie.getPosterPath());
                intent.putExtra("movie_vote_average", movie.getVoteAverage().toString());
                intent.putExtra("movie_release_date", movie.getReleaseDate());
                intent.putExtra("movie_overview", movie.getOverview());
                context.startActivity(intent);
            }
        });
    }

    /**
     * Get item count of the movie list
     * @return count of item
     */
    @Override
    public int getItemCount() {
        return movies.size();
    }

    /**
     * Create a viewHolder for Movie
     */
    class MovieViewHolder extends RecyclerView.ViewHolder{

        public TextView movie_title, movie_original_title, movie_release_date, movie_vote_average;
        public ImageView movie_poster;
        public RelativeLayout movie_layout;

        /**
         * Constructor of MovieViewHolder
         * @param itemView view of item
         */
        public MovieViewHolder(View itemView) {
            super(itemView);

            movie_title = itemView.findViewById(R.id.movieTitle);
            movie_poster = itemView.findViewById(R.id.moviePoster);
            movie_vote_average = itemView.findViewById(R.id.movieVoteAverage);
            movie_release_date = itemView.findViewById(R.id.movie_release);
            movie_layout = itemView.findViewById(R.id.movieLayout);
        }
    }
}
