package com.example.challenge.popular;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.challenge.R;
import com.example.challenge.popular.model.Show;
import com.example.challenge.popular.presenter.PopularShowsPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mfolcini on 10/09/2016.
 */

class PopularShowsAdapter extends RecyclerView.Adapter<PopularShowsHolder> {

    private List<Show> shows = new ArrayList<>();
    private PopularShowsPresenter presenter;

    PopularShowsAdapter(PopularShowsPresenter presenter) {
        this.presenter = presenter;
    }

    void addData(List<Show> data) {
        this.shows.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public PopularShowsHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_popular_show, viewGroup, false);
        return new PopularShowsHolder(viewGroup.getContext(), view, presenter);
    }

    @Override
    public void onBindViewHolder(PopularShowsHolder popularShowsHolder, int position) {
        popularShowsHolder.setItem(shows.get(position));
        popularShowsHolder.showImage(shows.get(position).getPosterPath());
        popularShowsHolder.showTitle(shows.get(position).getOriginalTitle());
        popularShowsHolder.showVoteAverage(Float.toString(shows.get(position).getVoteAverage()));
    }

    @Override
    public int getItemCount() {
        return shows.size();
    }

}