package com.example.challenge.popular.service;

import com.example.challenge.popular.model.Film;

import java.util.List;

import rx.Observable;

/**
 * Created by mfolcini on 10/09/2016.
 */

public interface FilmsService {

    Observable<List<Film>> getPopular(String page);
}
