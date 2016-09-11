package com.example.challenge.popular;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.challenge.R;
import com.example.challenge.base.dagger.AppComponent;
import com.example.challenge.base.dagger.ComponentsManager;
import com.example.challenge.dagger.PopularFilmsComponent;
import com.example.challenge.dagger.PopularFilmsModule;
import com.example.challenge.detail.DetailFilmActivity;
import com.example.challenge.popular.model.Film;
import com.example.challenge.popular.presenter.PopularFilmsPresenter;
import com.example.challenge.popular.service.FilmsService;
import com.github.ybq.endless.Endless;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.challenge.dagger.DaggerPopularFilmsComponent.builder;


public class PopularFilmsActivity extends AppCompatActivity implements PopularFilmsPresenter.View {

    private static final int INITIAL_PAGE = 1;

    @Inject
    FilmsService service;
    @Inject
    PopularFilmsPresenter presenter;
    @BindView(R.id.popular_recycler_view)
    RecyclerView popularFilmsList;
    private Endless endless;
    private PopularFilmsAdapter popularFilmsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPopularFilmsComponent().inject(this);
        setContentView(R.layout.activity_popular_films);
        ButterKnife.bind(this);
        configureView();
    }

    private void configureView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        popularFilmsList.setLayoutManager(linearLayoutManager);
        View loadingView = View.inflate(this, R.layout.layout_loading, null);
        popularFilmsList.setAdapter(popularFilmsAdapter = new PopularFilmsAdapter(presenter));
        endless = Endless.applyTo(popularFilmsList, loadingView);
        presenter.onLoadMore(INITIAL_PAGE);
        endless.setLoadMoreListener(page -> presenter.onLoadMore(page));
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachView(this);
    }

    @Override
    public void onPause() {
        presenter.detachView();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        presenter.destroy();
        super.onDestroy();
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

    @Override
    public void showPopularFilms(List<Film> films) {
        popularFilmsAdapter.addData(films);
        endless.loadMoreComplete();
    }

    @Override
    public void showFilmDetail(Film film) {
        startActivity(DetailFilmActivity.createIntent(this, film));
    }
}
