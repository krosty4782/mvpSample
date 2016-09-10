package com.example.challenge.dagger;

import com.example.challenge.service.ApiClient;

import dagger.Component;

/**
 * Created by mfolcini on 10/09/2016.
 */

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {

    ApiClient apiClient();
}
