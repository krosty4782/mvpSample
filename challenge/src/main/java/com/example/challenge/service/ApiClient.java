package com.example.challenge.service;

import retrofit.RestAdapter;

/**
 * Created by mfolcini on 10/09/2016.
 */

public class ApiClient {
    private static final String ENDPOINT = "http://docs.themoviedb.apiary.io/#reference/tv/";
    private final RestAdapter restAdapter;

    public ApiClient() {
        this.restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .build();
    }
}
