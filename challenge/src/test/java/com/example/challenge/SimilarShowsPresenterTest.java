package com.example.challenge;

import com.example.challenge.base.service.ShowsService;
import com.example.challenge.detail.presenter.SimilarShowsPresenter;
import com.example.challenge.detail.presenter.SimilarShowsPresenterImpl;
import com.example.challenge.popular.model.Show;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;

import rx.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SimilarShowsPresenterTest {

    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

    @Mock
    ShowsService mockedService;

    @Mock
    SimilarShowsPresenter.View mockedView;

    @Test
    public void test_onAttachView_showSimilarShow() {
        Show show = new Show();
        show.setId(1);
        when(mockedService.getSimilar("1", "1")).thenReturn(Observable.just(new ArrayList<>()));
        when(mockedService.getShow("1")).thenReturn(Observable.just(show));
        final SimilarShowsPresenter similarShowsPresenter = new SimilarShowsPresenterImpl(mockedService, show) {
        };
        similarShowsPresenter.attachView(mockedView);

        verify(mockedView).showSimilarShow(show);
    }

    @Test
    public void test_onAttachView_callGetSimilarService() {
        Show show = new Show();
        show.setId(1);
        when(mockedService.getSimilar("1", "1")).thenReturn(Observable.just(new ArrayList<>()));
        when(mockedService.getShow("1")).thenReturn(Observable.just(show));
        final SimilarShowsPresenter similarShowsPresenter = new SimilarShowsPresenterImpl(mockedService, show) {
        };
        similarShowsPresenter.attachView(mockedView);

        verify(mockedService).getSimilar("1", "1");
    }
}