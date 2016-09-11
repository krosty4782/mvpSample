package com.example.challenge;

import com.example.challenge.popular.model.Show;
import com.example.challenge.popular.presenter.PopularShowsPresenter;
import com.example.challenge.popular.presenter.PopularShowsPresenterImpl;
import com.example.challenge.base.service.ShowsService;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;

import rx.Observable;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PopularShowsPresenterTest {

    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

    @Mock
    ShowsService mockedService;

    @Mock
    PopularShowsPresenter.View mockedView;

    @Test
    public void test_onLoadMore_showPopularShows() {
        when(mockedService.getPopular("1")).thenReturn(Observable.just(new ArrayList<Show>()));
        final PopularShowsPresenterImpl popularShowsPresenter = new PopularShowsPresenterImpl(mockedService);
        popularShowsPresenter.attachView(mockedView);
        popularShowsPresenter.onLoadMore(1);
        verify(mockedView).showPopularShows(any());
    }

    @Test
    public void test_onShowSelected_showShowDetail() {
        Show show = new Show();
        final PopularShowsPresenterImpl popularShowsPresenter = new PopularShowsPresenterImpl(mockedService);
        popularShowsPresenter.attachView(mockedView);
        popularShowsPresenter.onShowSelected(show);
        verify(mockedView).showShowDetail(show);
    }
}