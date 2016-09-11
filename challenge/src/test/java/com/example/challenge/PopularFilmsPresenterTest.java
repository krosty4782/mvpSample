package com.example.challenge;

import com.example.challenge.popular.model.Film;
import com.example.challenge.popular.presenter.PopularFilmsPresenter;
import com.example.challenge.popular.presenter.PopularFilmsPresenterImpl;
import com.example.challenge.popular.service.FilmsService;

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

public class PopularFilmsPresenterTest {

    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

    @Mock
    FilmsService mockedService;

    @Mock
    PopularFilmsPresenter.View mockedView;

    @Test
    public void test_onLoadMore_showPopularFilms() {
        when(mockedService.getPopular("1")).thenReturn(Observable.just(new ArrayList<Film>()));
        final PopularFilmsPresenterImpl popularFilmsPresenter = new PopularFilmsPresenterImpl(mockedService);
        popularFilmsPresenter.attachView(mockedView);
        popularFilmsPresenter.onLoadMore(1);
        verify(mockedView).showPopularFilms(any());
    }

    @Test
    public void test_onFilmSelected_showFilmDetail() {
        Film film = new Film();
        final PopularFilmsPresenterImpl popularFilmsPresenter = new PopularFilmsPresenterImpl(mockedService);
        popularFilmsPresenter.attachView(mockedView);
        popularFilmsPresenter.onFilmSelected(film);
        verify(mockedView).showFilmDetail(film);
    }
}