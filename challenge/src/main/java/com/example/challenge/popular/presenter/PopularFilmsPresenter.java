package com.example.challenge.popular.presenter;

import com.example.challenge.base.Presenter;
import com.example.challenge.base.PresenterView;
import com.example.challenge.popular.model.Film;

import java.util.List;

public interface PopularFilmsPresenter extends Presenter<PopularFilmsPresenter.View> {

    void onLoadMore(int pages);

    void onFilmSelected(Film film);

    interface View extends PresenterView {
        void showPopularFilms(List<Film> films);
        void showFilmDetail(Film film);
    }
}
