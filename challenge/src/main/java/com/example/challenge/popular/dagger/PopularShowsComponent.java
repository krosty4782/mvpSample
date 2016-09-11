package com.example.challenge.popular.dagger;

import com.example.challenge.popular.PopularShowsActivity;
import com.example.challenge.base.dagger.AppComponent;
import com.example.challenge.base.dagger.BaseComponent;

import dagger.Component;

/**
 * Created by mfolcini on 10/09/2016.
 */
@PopularShowsScope
@Component(dependencies = AppComponent.class, modules = PopularShowsModule.class)
public interface PopularShowsComponent extends BaseComponent {

    String KEY = PopularShowsComponent.class.getSimpleName();

    void inject(PopularShowsActivity activity);

}
