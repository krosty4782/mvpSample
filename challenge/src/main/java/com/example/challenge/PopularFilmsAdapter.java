package com.example.challenge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.challenge.model.Film;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.challenge.PopularFilmsAdapter.IMAGE_PATH;

/**
 * Created by mfolcini on 10/09/2016.
 */

class PopularFilmsAdapter extends RecyclerView.Adapter<PopularFilmsHolder> {

    static final String IMAGE_PATH = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/";

    private List<Film> data = new ArrayList<>();

    void addData(List<Film> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public PopularFilmsHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_popular_film, viewGroup, false);
        return new PopularFilmsHolder(viewGroup.getContext(), view);
    }

    @Override
    public void onBindViewHolder(PopularFilmsHolder popularFilmsHolder, int position) {
        popularFilmsHolder.showImage(data.get(position).getPosterPath());
        popularFilmsHolder.showTitle(data.get(position).getTitle());
        popularFilmsHolder.showVoteAverage(Float.toString(data.get(position).getVoteAverage()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}

class PopularFilmsHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.popular_film_image)
    ImageView filmImage;

    @BindView(R.id.popular_film_title)
    TextView filmTitle;

    @BindView(R.id.popular_film_vote_average)
    TextView filmVoteAverage;

    private Context context;

    PopularFilmsHolder(Context context, View itemView) {
        super(itemView);
        this.context = context;
        ButterKnife.bind(this, itemView);
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
}
