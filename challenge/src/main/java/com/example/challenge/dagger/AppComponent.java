package com.example.challenge.dagger;

import com.example.challenge.ChallengeApplication;
import com.example.challenge.service.ApiClient;
import com.example.challenge.service.FilmsApi;

import dagger.Component;

/**
 * Created by mfolcini on 10/09/2016.
 */

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent extends BaseComponent {

    ApiClient apiClient();

    FilmsApi filmsApi();

    void inject(ChallengeApplication application);
}
