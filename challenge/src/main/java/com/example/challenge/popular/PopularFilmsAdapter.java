package com.example.challenge.popular;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.challenge.R;
import com.example.challenge.popular.model.Film;
import com.example.challenge.popular.presenter.PopularFilmsPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.challenge.popular.PopularFilmsAdapter.IMAGE_PATH;

/**
 * Created by mfolcini on 10/09/2016.
 */

class PopularFilmsAdapter extends RecyclerView.Adapter<PopularFilmsHolder> {

    static final String IMAGE_PATH = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/";

    private List<Film> films = new ArrayList<>();
    private PopularFilmsPresenter presenter;

    PopularFilmsAdapter(PopularFilmsPresenter presenter) {
        this.presenter = presenter;
    }

    void addData(List<Film> data) {
        this.films.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public PopularFilmsHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_popular_film, viewGroup, false);
        return new PopularFilmsHolder(viewGroup.getContext(), view, presenter);
    }

    @Override
    public void onBindViewHolder(PopularFilmsHolder popularFilmsHolder, int position) {
        popularFilmsHolder.setItem(films.get(position));
        popularFilmsHolder.showImage(films.get(position).getPosterPath());
        popularFilmsHolder.showTitle(films.get(position).getTitle());
        popularFilmsHolder.showVoteAverage(Float.toString(films.get(position).getVoteAverage()));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

}

class PopularFilmsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.popular_film_image)
    ImageView filmImage;
    @BindView(R.id.popular_film_title)
    TextView filmTitle;
    @BindView(R.id.popular_film_vote_average)
    TextView filmVoteAverage;
    private Context context;
    private PopularFilmsPresenter presenter;
    private Film film;

    PopularFilmsHolder(Context context, View itemView, PopularFilmsPresenter presenter) {
        super(itemView);
        this.context = context;
        this.presenter = presenter;
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    void showImage(String imageUrl) {
        Glide.with(context).load(IMAGE_PATH + imageUrl).into(filmImage);
    }

    void showTitle(String title) {
        filmTitle.setText(title);
    }

    void showVoteAverage(String voteAverage) {
        filmVoteAverage.setText(voteAverage);
    }

    void setItem(Film film) {
        this.film = film;
    }

    @Override
    public void onClick(View view) {
        presenter.onFilmSelected(film);
    }
}
