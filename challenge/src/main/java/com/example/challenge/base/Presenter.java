package com.example.challenge.base;

public interface Presenter<T extends PresenterView> {

    void attachView(T presenterView);

    void detachView();

    void destroy();
}
