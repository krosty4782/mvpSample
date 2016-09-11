package com.example.challenge.popular.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.challenge.popular.model.Show;
import com.example.challenge.base.service.ShowsService;

import rx.subscriptions.CompositeSubscription;

public class PopularShowsPresenterImpl implements PopularShowsPresenter {

    private View view;
    private ShowsService service;
    private CompositeSubscription subscriptions = new CompositeSubscription();

    public PopularShowsPresenterImpl(@NonNull ShowsService service) {
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
                    view.showPopularShows(result);
                }, e -> Log.e("ERROR", e.getMessage())));
    }

    @Override
    public void onShowSelected(Show show) {
        view.showShowDetail(show);
    }

    @Override
    public void detachView() {

    }

    @Override
    public void destroy() {
        subscriptions.clear();
    }
}
