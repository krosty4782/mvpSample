package com.example.challenge.detail.dagger;

import com.example.challenge.base.dagger.AppComponent;
import com.example.challenge.base.dagger.BaseComponent;
import com.example.challenge.detail.SimilarShowsActivity;

import dagger.Component;

/**
 * Created by mfolcini on 10/09/2016.
 */
@SimilarShowsScope
@Component(dependencies = AppComponent.class, modules = SimilarShowsModule.class)
public interface SimilarShowsComponent extends BaseComponent {

    String KEY = SimilarShowsComponent.class.getSimpleName();

    void inject(SimilarShowsActivity activity);

}
