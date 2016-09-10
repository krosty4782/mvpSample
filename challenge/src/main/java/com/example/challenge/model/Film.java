package com.example.challenge.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mfolcini on 10/09/2016.
 */

public class Film {
    boolean adult;
    @SerializedName("backdrop_path")
    String backdropPath;
    @SerializedName("genre_ids")
    List<Integer> genreIds;
    int id;
    @SerializedName("original_language")
    String originalLanguage;
    @SerializedName("original_title")
    String originalTitle;
    String overview;
    @SerializedName("release_date")
    String releaseDate;
    @SerializedName("poster_path")
    String posterPath;
    float popularity;
    String title;
    boolean video;
    @SerializedName("vote_average")
    float voteAverage;
    @SerializedName("vote_count")
    int voteCount;
}
