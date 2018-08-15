package com.example.nilay.movieapp.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {

    /**
     * The number of people who voted on the movie
     */
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;

    /**
     * Movie id on The MovieDatabase
     */
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * Information about movie includes video as a trailer
     */
    @SerializedName("video")
    @Expose
    private Boolean video;

    /**
     * Average of vote
     */
    @SerializedName("vote_average")
    @Expose
    private Float voteAverage;
    @SerializedName("title")
    @Expose

    /**
     * Title of movie
     */
    private String title;
    @SerializedName("popularity")
    @Expose

    /**
     * Popularity of movie
     */
    private Float popularity;

    /**
     * Poster path of movie
     */
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("original_language")
    @Expose

    /**
     * Original language of movie
     */
    private String originalLanguage;
    @SerializedName("original_title")
    @Expose

    /**
     * Original title of movie
     */
    private String originalTitle;
    @SerializedName("genre_ids")
    @Expose

    /**
     * Genre IDs
     */
    private List<Integer> genreIds = new ArrayList<Integer>();
    @SerializedName("backdrop_path")
    @Expose

    /**
     * BackdropPath of movie
     */
    private String backdropPath;
    @SerializedName("adult")
    @Expose

    /**
     * Information of availability for adults
     */
    private Boolean adult;
    @SerializedName("overview")
    @Expose

    /**
     * Overwiew of movie
     */
    private String overview;

    /**
     * Release date of movie
     */
    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    /**
     * Get release date of movie(Date)
     * @return release date
     */
    public Date getRelease(){
        String[] output = getReleaseDate().split("-");
        return new Date(Integer.parseInt(output[0]), Integer.parseInt(output[1]), Integer.parseInt(output[2]));
    }

    /**
     * No args constructor for use in serialization
     */
    public Movie() { }

    /**
     *
     * @param genreIds genreIds
     * @param id movie ID
     * @param title Movie Title
     * @param releaseDate Release date of movie
     * @param overview Overview of movie
     * @param posterPath Poster path of movie
     * @param originalTitle Original title of movie
     * @param voteAverage Average vote of movie
     * @param originalLanguage Original language of movie
     * @param adult For adults?
     * @param backdropPath Backdorp pth of movie
     * @param voteCount Number of people voting
     * @param video information of including video
     * @param popularity Popularity of movie
     */
    public Movie(Integer voteCount, Integer id, Boolean video, Float voteAverage, String title, Float popularity,
                 String posterPath, String originalLanguage, String originalTitle, List<Integer> genreIds,
                 String backdropPath, Boolean adult, String overview, String releaseDate) {
        super();
        this.voteCount = voteCount;
        this.id = id;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.genreIds = genreIds;
        this.backdropPath = backdropPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    /**
     * Base URL for movie's image
     */
    String baseImageUrl = "https://image.tmdb.org/t/p/w500";

    /**
     * Getter for vote count
     * @return count of vote
     */
    public Integer getVoteCount() {
        return voteCount;
    }

    /**
     * Setter for vote count
     * @param voteCount count of vote
     */
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    /**
     * Getter for movie ID
     * @return movie ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for movie ID
     * @param id Movie ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for information of movie's video
     * @return true if it has video otherwise false
     */
    public Boolean getVideo() {
        return video;
    }

    /**
     * Setter for information of movie's video
     * @param video information of including video
     */
    public void setVideo(Boolean video) {
        this.video = video;
    }

    /**
     * Getter for average of vote
     * @return average of vote
     */
    public Float getVoteAverage() {
        return voteAverage;
    }

    /**
     * Setter for average of vote
     * @param voteAverage average of vote
     */
    public void setVoteAverage(Float voteAverage) {
        this.voteAverage = voteAverage;
    }

    /**
     * Getter for movie title
     * @return movie title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for movie title
     * @param title title of movie
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for popularity of movie
     * @return popularity of movie
     */
    public Float getPopularity() {
        return popularity;
    }

    /**
     * Setter for popularity of movie
     * @param popularity popularity of movie
     */
    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    /**
     * Getter for poster path of movie.
     * @return poster path of movie
     */
    public String getPosterPath() {
        return baseImageUrl + posterPath;
    }

    /**
     * Setter for poster path of movie
     * @param posterPath poster path of movie
     */
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    /**
     * Getter for original language of movie
     * @return original language of movie
     */
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    /**
     * Setter for original language of movie
     * @param originalLanguage original language of movie
     */
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    /**
     * Getter for original title of movie
     * @return original title of movie
     */
    public String getOriginalTitle() {
        return originalTitle;
    }

    /**
     * Setter of original title of movie
     * @param originalTitle original tittle of movie
     */
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    /**
     * Getter for overview of movie
     * @return overview of movie
     */
    public String getOverview() {
        return overview;
    }

    /**
     * Setter for overview of movie
     * @param overview overview of movie
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     * Getter for release date of movie
     * @return release date of movie
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * Setter for release date of movie
     * @param releaseDate release date of movie
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

}
