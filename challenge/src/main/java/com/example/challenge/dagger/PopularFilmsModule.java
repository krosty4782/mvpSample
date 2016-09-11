package com.example.challenge.dagger;

import android.support.annotation.NonNull;

import com.example.challenge.popular.presenter.PopularFilmsPresenter;
import com.example.challenge.popular.presenter.PopularFilmsPresenterImpl;
import com.example.challenge.popular.service.ApiFilmsService;
import com.example.challenge.popular.service.FilmsApi;
import com.example.challenge.popular.service.FilmsService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mfolcini on 10/09/2016.
 */

@Module
public class PopularFilmsModule {

    String apiKey = "70bea916230b169eb500a171c5264979";

    @Provides
    @PopularFilmsScope
    public PopularFilmsPresenter providePopularFilmsPresenter(@NonNull FilmsService service) {

        return new PopularFilmsPresenterImpl(service);
    }

    @Provides
    @PopularFilmsScope
    public FilmsService provideFilmsService(FilmsApi filmsApi) {

        return new ApiFilmsService(filmsApi, apiKey);
    }
}
