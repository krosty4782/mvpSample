package com.example.challenge.popular.service;

import com.example.challenge.popular.model.Popular;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by mfolcini on 10/09/2016.
 */

public interface FilmsApi {

    @GET("/popular")
    Observable<Popular> getPopular(@Query("page") String page, @Query("api_key") String apiKey);
}