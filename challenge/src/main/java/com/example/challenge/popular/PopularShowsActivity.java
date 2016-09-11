package com.example.challenge.popular;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.challenge.R;
import com.example.challenge.base.dagger.AppComponent;
import com.example.challenge.base.dagger.ComponentsManager;
import com.example.challenge.base.service.ShowsService;
import com.example.challenge.detail.SimilarShowsActivity;
import com.example.challenge.popular.dagger.PopularShowsComponent;
import com.example.challenge.popular.dagger.PopularShowsModule;
import com.example.challenge.popular.model.Show;
import com.example.challenge.popular.presenter.PopularShowsPresenter;
import com.github.ybq.endless.Endless;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.challenge.popular.dagger.DaggerPopularShowsComponent.builder;


public class PopularShowsActivity extends AppCompatActivity implements PopularShowsPresenter.View {

    private static final int INITIAL_PAGE = 1;

    @Inject
    PopularShowsPresenter presenter;
    @BindView(R.id.popular_recycler_view)
    RecyclerView popularShowsList;
    private Endless endless;
    private PopularShowsAdapter popularShowsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPopularShowsComponent().inject(this);
        setContentView(R.layout.activity_popular_shows);
        ButterKnife.bind(this);
    }

    private void configureView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        popularShowsList.setLayoutManager(linearLayoutManager);
        View loadingView = View.inflate(this, R.layout.layout_loading, null);
        popularShowsList.setAdapter(popularShowsAdapter = new PopularShowsAdapter(presenter));
        endless = Endless.applyTo(popularShowsList, loadingView);
        presenter.onLoadMore(INITIAL_PAGE);
        endless.setLoadMoreListener(page -> presenter.onLoadMore(page));
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachView(this);
        configureView();
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

    private PopularShowsComponent getPopularShowsComponent() {
        PopularShowsComponent popularShowsComponent = ComponentsManager.get().getBaseComponent(PopularShowsComponent.KEY);
        if (popularShowsComponent == null) {
            AppComponent appComponent = ComponentsManager.get().getAppComponent();
            PopularShowsModule popularShowsModule = new PopularShowsModule();
            popularShowsComponent = builder().appComponent(appComponent).popularShowsModule(popularShowsModule).build();
            ComponentsManager.get().putBaseComponent(PopularShowsComponent.KEY, popularShowsComponent);
        }
        return popularShowsComponent;
    }

    @Override
    public void showPopularShows(List<Show> shows) {
        popularShowsAdapter.addData(shows);
        endless.loadMoreComplete();
    }

    @Override
    public void showShowDetail(Show show) {
        startActivity(SimilarShowsActivity.createIntent(this, show));
    }
}
