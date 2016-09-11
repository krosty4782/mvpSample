package com.example.challenge.base.dagger;

import com.example.challenge.ChallengeApplication;
import com.example.challenge.base.service.ApiClient;
import com.example.challenge.base.service.ShowsApi;

import dagger.Component;

/**
 * Created by mfolcini on 10/09/2016.
 */

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent extends BaseComponent {

    ApiClient apiClient();

    ShowsApi showsApi();

    void inject(ChallengeApplication application);
}
