package com.example.challenge.base.service;

import com.example.challenge.popular.model.Show;

import java.util.List;

import rx.Observable;

/**
 * Created by mfolcini on 10/09/2016.
 */

public interface ShowsService {

    Observable<List<Show>> getPopular(String page);

    Observable<List<Show>> getSimilar(String id, String page);

    Observable<Show> getShow(String id);
}
