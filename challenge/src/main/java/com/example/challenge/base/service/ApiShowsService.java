package com.example.challenge.base.service;

import android.support.annotation.NonNull;

import com.example.challenge.popular.model.Show;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by mfolcini on 10/09/2016.
 */

public class ApiShowsService implements ShowsService {

    private static final String API_KEY = "70bea916230b169eb500a171c5264979";
    private ShowsApi api;
    private Map<String, Observable<List<Show>>> cachedSimilar = new HashMap<>();
    private Map<String, Observable<List<Show>>> cachedPopular = new HashMap<>();
    private Map<String, Observable<Show>> cachedShows = new HashMap<>();

    public ApiShowsService(@NonNull ShowsApi api) {
        this.api = api;
    }

    @Override
    public Observable<List<Show>> getPopular(@NonNull String page) {
        if (cachedPopular.containsKey(page)) {
            return cachedPopular.get(page);
        }

        return api.getPopular(page, API_KEY)
                .map(popular -> {
                    List<Show> results = popular.getResults();
                    cachedPopular.put(page, Observable.just(results));
                    return results;
                })
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<Show>> getSimilar(@NonNull String id, String page) {
        if (cachedSimilar.containsKey(id)) {
            return cachedSimilar.get(id);
        }

        return api.getSimilar(id, page, API_KEY)
                .map(similar -> {
                    List<Show> results = similar.getResults();
                    cachedSimilar.put(id, Observable.just(results));
                    return results;
                })
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Show> getShow(@NonNull String id) {
        if (cachedShows.containsKey(id)) {
            return cachedShows.get(id);
        }
        return api.getShow(id, API_KEY)
                .map(show -> {
                    cachedShows.put(id, Observable.just(show));
                    return show;
                })
                .observeOn(AndroidSchedulers.mainThread());
    }
}
