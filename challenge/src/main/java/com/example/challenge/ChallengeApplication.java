package com.example.challenge;

import android.app.Application;

import com.example.challenge.dagger.AppComponent;
import com.example.challenge.dagger.AppModule;
import com.example.challenge.dagger.ComponentsManager;

import static com.example.challenge.dagger.DaggerAppComponent.builder;


/**
 * Created by mfolcini on 10/09/2016.
 */

public class ChallengeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initComponents();
    }

    protected void initComponents() {
        AppComponent appComponent = builder().appModule(new AppModule()).build();
        ComponentsManager.get().setAppComponent(appComponent);
        appComponent.inject(this);
    }
}
