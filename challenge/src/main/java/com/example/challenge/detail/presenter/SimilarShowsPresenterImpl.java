package com.example.challenge.detail.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.challenge.base.service.ShowsService;
import com.example.challenge.popular.model.Show;

import rx.subscriptions.CompositeSubscription;

public class SimilarShowsPresenterImpl implements SimilarShowsPresenter {

    private static final String SIMILAR_PAGE = "1";

    private View view;
    private ShowsService service;
    private Show show;
    private CompositeSubscription subscriptions = new CompositeSubscription();

    public SimilarShowsPresenterImpl(@NonNull ShowsService service,
                                     @NonNull Show show) {
        this.service = service;
        this.show = show;
    }

    @Override
    public void attachView(View presenterView) {
        this.view = presenterView;
        view.showSimilarShow(show);
        subscriptions.add(service.getSimilar(Integer.toString(show.getId()), SIMILAR_PAGE)
                .flatMapIterable(showList -> showList)
                .flatMap(show -> service.getShow(Integer.toString(show.getId())))
                .subscribe(show -> view.showSimilarShow(show), error -> Log.e("ERROR", error.getMessage())));
    }

    @Override
    public void detachView() {

    }

    @Override
    public void destroy() {
        subscriptions.clear();
    }
}
