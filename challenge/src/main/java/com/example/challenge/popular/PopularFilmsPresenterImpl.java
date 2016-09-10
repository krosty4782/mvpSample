package com.example.challenge.popular;

import android.support.annotation.NonNull;

import com.example.challenge.service.FilmsService;

public class PopularFilmsPresenterImpl implements PopularFilmsPresenter {

    private View view;
    private FilmsService service;

    public PopularFilmsPresenterImpl(@NonNull FilmsService service) {
        this.service = service;
    }

    @Override
    public void attachView(View presenterView) {
        this.view = presenterView;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void destroy() {

    }
}
