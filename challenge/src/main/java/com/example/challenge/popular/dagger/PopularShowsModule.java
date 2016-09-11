package com.example.challenge.popular.dagger;

import android.support.annotation.NonNull;

import com.example.challenge.base.service.ApiShowsService;
import com.example.challenge.base.service.ShowsApi;
import com.example.challenge.base.service.ShowsService;
import com.example.challenge.popular.presenter.PopularShowsPresenter;
import com.example.challenge.popular.presenter.PopularShowsPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mfolcini on 10/09/2016.
 */

@Module
public class PopularShowsModule {

    @Provides
    @PopularShowsScope
    public PopularShowsPresenter providePopularShowsPresenter(@NonNull ShowsService service) {

        return new PopularShowsPresenterImpl(service);
    }

    @Provides
    @PopularShowsScope
    public ShowsService provideShowsService(ShowsApi showsApi) {

        return new ApiShowsService(showsApi);
    }
}
