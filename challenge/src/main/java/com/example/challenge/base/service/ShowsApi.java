package com.example.challenge.base.service;

import com.example.challenge.popular.model.Show;
import com.example.challenge.popular.model.Popular;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by mfolcini on 10/09/2016.
 */

public interface ShowsApi {

    @GET("/popular")
    Observable<Popular> getPopular(@Query("page") String page, @Query("api_key") String apiKey);

    @GET("/{id}/similar")
    Observable<Popular> getSimilar(@Path("id") String id, @Query("page") String page, @Query("api_key") String apiKey);

    @GET("/{id}")
    Observable<Show> getShow(@Path("id") String id, @Query("api_key") String apiKey);
}
