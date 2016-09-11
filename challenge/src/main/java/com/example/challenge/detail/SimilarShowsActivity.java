package com.example.challenge.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.challenge.R;
import com.example.challenge.base.dagger.AppComponent;
import com.example.challenge.base.dagger.ComponentsManager;
import com.example.challenge.detail.dagger.SimilarShowsComponent;
import com.example.challenge.detail.dagger.SimilarShowsModule;
import com.example.challenge.detail.presenter.SimilarShowsPresenter;
import com.example.challenge.popular.model.Show;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.challenge.detail.dagger.DaggerSimilarShowsComponent.builder;

public class SimilarShowsActivity extends AppCompatActivity implements SimilarShowsPresenter.View {

    private static final String EXTRA_FILM = "extra_show";

    @Inject
    SimilarShowsPresenter presenter;

    @BindView(R.id.similar_shows_pager)
    ViewPager similarShowsPager;
    private List<Show> shows = new ArrayList<>();
    private SimilarShowsAdapter similarShowsAdapter = new SimilarShowsAdapter(this, shows);

    public static Intent createIntent(Context context, Show show) {
        Intent intent = new Intent(context, SimilarShowsActivity.class);
        intent.putExtra(EXTRA_FILM, show);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSimilarShowsComponent().inject(this);
        setContentView(R.layout.activity_similar_shows);
        ButterKnife.bind(this);
        similarShowsPager.setAdapter(similarShowsAdapter);
    }

    private SimilarShowsComponent getSimilarShowsComponent() {
        SimilarShowsComponent similarShowsComponent = ComponentsManager.get().getBaseComponent(SimilarShowsComponent.KEY);
        if (similarShowsComponent == null) {
            AppComponent appComponent = ComponentsManager.get().getAppComponent();
            SimilarShowsModule similarShowsModule = new SimilarShowsModule(extractShowFromIntent());
            similarShowsComponent = builder().appComponent(appComponent).similarShowsModule(similarShowsModule).build();
            ComponentsManager.get().putBaseComponent(SimilarShowsComponent.KEY, similarShowsComponent);
        }
        return similarShowsComponent;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachView(this);
    }

    @Override
    public void showSimilarShow(Show show) {
        shows.add(show);
        similarShowsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPause() {
        presenter.detachView();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        if (isFinishing()) {
            ComponentsManager.get().removeBaseComponent(SimilarShowsComponent.KEY);
            presenter.destroy();
        }
        super.onDestroy();
    }

    private Show extractShowFromIntent() {
        return (Show) getIntent().getSerializableExtra(EXTRA_FILM);
    }
}
