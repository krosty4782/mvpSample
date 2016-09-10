package com.example.challenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.challenge.dagger.AppComponent;
import com.example.challenge.dagger.ComponentsManager;
import com.example.challenge.dagger.PopularFilmsComponent;
import com.example.challenge.dagger.PopularFilmsModule;
import com.example.challenge.service.FilmsService;

import javax.inject.Inject;

import static com.example.challenge.dagger.DaggerPopularFilmsComponent.builder;


public class PopularFilmsActivity extends AppCompatActivity {

    @Inject
    FilmsService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPopularFilmsComponent().inject(this);
        setContentView(R.layout.activity_home);
        service.getPopular("1").subscribe(result -> Log.d("result", result.toString()), e -> Log.e("result", e.getMessage()));
    }

    private PopularFilmsComponent getPopularFilmsComponent() {
        PopularFilmsComponent popularFilmsComponent = ComponentsManager.get().getBaseComponent(PopularFilmsComponent.KEY);
        if (popularFilmsComponent == null) {
            AppComponent appComponent = ComponentsManager.get().getAppComponent();
            PopularFilmsModule popularFilmsModule = new PopularFilmsModule();
            popularFilmsComponent = builder().appComponent(appComponent).popularFilmsModule(popularFilmsModule).build();
            ComponentsManager.get().putBaseComponent(PopularFilmsComponent.KEY, popularFilmsComponent);
        }
        return popularFilmsComponent;
    }
}