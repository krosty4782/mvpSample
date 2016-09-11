package com.example.challenge.popular;

import com.example.challenge.base.Presenter;
import com.example.challenge.base.PresenterView;
import com.example.challenge.model.Film;

import java.util.List;

public interface PopularFilmsPresenter extends Presenter<PopularFilmsPresenter.View> {

    void onLoadMore(int pages);

    interface View extends PresenterView {
        void showPopularFilms(List<Film> films);
    }
}
