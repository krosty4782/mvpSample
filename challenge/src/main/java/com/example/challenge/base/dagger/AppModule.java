package com.example.challenge.base.dagger;

import com.example.challenge.base.service.ApiClient;
import com.example.challenge.base.service.ShowsApi;

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
    public ShowsApi provideShowsApi(ApiClient apiClient) {
        return apiClient.api(ShowsApi.class);
    }
}
