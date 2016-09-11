package com.example.challenge.dagger;

import com.example.challenge.popular.PopularFilmsActivity;
import com.example.challenge.base.dagger.AppComponent;
import com.example.challenge.base.dagger.BaseComponent;

import dagger.Component;

/**
 * Created by mfolcini on 10/09/2016.
 */
@PopularFilmsScope
@Component(dependencies = AppComponent.class, modules = PopularFilmsModule.class)
public interface PopularFilmsComponent extends BaseComponent {

    String KEY = PopularFilmsComponent.class.getSimpleName();

    void inject(PopularFilmsActivity activity);

}
