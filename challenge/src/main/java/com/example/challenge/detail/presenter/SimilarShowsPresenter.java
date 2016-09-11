package com.example.challenge.detail.presenter;

import com.example.challenge.base.Presenter;
import com.example.challenge.base.PresenterView;
import com.example.challenge.popular.model.Show;

import java.util.List;

public interface SimilarShowsPresenter extends Presenter<SimilarShowsPresenter.View> {

    interface View extends PresenterView {
        void showSimilarShow(Show show);
    }
}
