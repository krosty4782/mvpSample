package com.example.challenge.detail.dagger;

import android.support.annotation.NonNull;

import com.example.challenge.base.service.ApiShowsService;
import com.example.challenge.base.service.ShowsApi;
import com.example.challenge.base.service.ShowsService;
import com.example.challenge.detail.presenter.SimilarShowsPresenter;
import com.example.challenge.detail.presenter.SimilarShowsPresenterImpl;
import com.example.challenge.popular.model.Show;
import com.example.challenge.popular.presenter.PopularShowsPresenter;
import com.example.challenge.popular.presenter.PopularShowsPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mfolcini on 10/09/2016.
 */

@Module
public class SimilarShowsModule {

    private final Show show;

    public SimilarShowsModule(@NonNull Show show) {
        this.show = show;
    }

    @Provides
    @SimilarShowsScope
    public SimilarShowsPresenter providePopularShowsPresenter(@NonNull ShowsService service) {

        return new SimilarShowsPresenterImpl(service, show);
    }

    @Provides
    @SimilarShowsScope
    public ShowsService provideShowsService(ShowsApi showsApi) {

        return new ApiShowsService(showsApi);
    }
}
