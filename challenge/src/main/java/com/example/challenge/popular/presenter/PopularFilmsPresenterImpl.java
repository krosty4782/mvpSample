package com.example.challenge.popular.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.challenge.popular.model.Film;
import com.example.challenge.popular.service.FilmsService;

import rx.subscriptions.CompositeSubscription;

public class PopularFilmsPresenterImpl implements PopularFilmsPresenter {

    private View view;
    private FilmsService service;
    private CompositeSubscription subscriptions = new CompositeSubscription();

    public PopularFilmsPresenterImpl(@NonNull FilmsService service) {
        this.service = service;
    }

    @Override
    public void attachView(View presenterView) {
        this.view = presenterView;
    }

    @Override
    public void onLoadMore(int page) {
        subscriptions.add(service.getPopular(Integer.toString(page))
                .subscribe(result -> {
                    view.showPopularFilms(result);
                }, e -> Log.e("ERROR", e.getMessage())));
    }

    @Override
    public void onFilmSelected(Film film) {
        view.showFilmDetail(film);
    }

    @Override
    public void detachView() {

    }

    @Override
    public void destroy() {
        subscriptions.clear();
    }
}
