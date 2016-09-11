package com.example.challenge.popular.presenter;

import com.example.challenge.base.Presenter;
import com.example.challenge.base.PresenterView;
import com.example.challenge.popular.model.Show;

import java.util.List;

public interface PopularShowsPresenter extends Presenter<PopularShowsPresenter.View> {

    void onLoadMore(int pages);

    void onShowSelected(Show show);

    interface View extends PresenterView {
        void showPopularShows(List<Show> shows);
        void showShowDetail(Show show);
    }
}
