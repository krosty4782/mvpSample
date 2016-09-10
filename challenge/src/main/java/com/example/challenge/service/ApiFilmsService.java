package com.example.challenge.service;

import android.support.annotation.NonNull;

import com.example.challenge.model.Film;
import com.example.challenge.model.Popular;

import java.util.List;

import rx.Observable;

/**
 * Created by mfolcini on 10/09/2016.
 */

public class ApiFilmsService implements FilmsService{

    private FilmsApi api;
    private String apiKey;

    public ApiFilmsService(@NonNull FilmsApi api, @NonNull String apiKey) {

        this.api = api;
        this.apiKey = apiKey;
    }

    @Override
    public Observable<List<Film>> getPopular(String page) {

        return api.getPopular(page, apiKey).map(Popular::getResults);
    }
}
