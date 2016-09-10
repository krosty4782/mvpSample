package com.example.challenge.dagger;

import com.example.challenge.service.ApiClient;
import com.example.challenge.service.FilmsApi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mfolcini on 10/09/2016.
 */

@Module
public class AppModule {

    @Provides
    @AppScope
    public ApiClient provideApiClient() {
        return new ApiClient();
    }

    @Provides
    @AppScope
    public FilmsApi provideFilmsApi(ApiClient apiClient) {
        return apiClient.api(FilmsApi.class);
    }
}
