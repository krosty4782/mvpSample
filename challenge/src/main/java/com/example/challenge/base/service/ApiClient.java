package com.example.challenge.base.service;

import retrofit.RestAdapter;

/**
 * Created by mfolcini on 10/09/2016.
 */

public class ApiClient {
    private static final String ENDPOINT = "http://api.themoviedb.org/3/tv/";
    private final RestAdapter restAdapter;

    public ApiClient() {
        this.restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .build();
    }

    public <T> T api(Class<T> service) {
        return restAdapter.create(service);
    }
}
