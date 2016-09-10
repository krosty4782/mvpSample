package com.example.challenge.dagger;

import com.example.challenge.service.ApiFilmsService;
import com.example.challenge.service.FilmsApi;
import com.example.challenge.service.FilmsService;

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
    public FilmsService provideFilmsService(FilmsApi filmsApi) {

        return new ApiFilmsService(filmsApi, apiKey);
    }
}
