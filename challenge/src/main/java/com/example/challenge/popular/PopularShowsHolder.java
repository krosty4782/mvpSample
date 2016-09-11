package com.example.challenge.popular;

/**
 * Created by mfolcini on 11/09/2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.challenge.R;
import com.example.challenge.popular.model.Show;
import com.example.challenge.popular.presenter.PopularShowsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PopularShowsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public static final String IMAGE_PATH = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/";

    @BindView(R.id.popular_show_image)
    ImageView showImage;
    @BindView(R.id.popular_show_title)
    TextView showTitle;
    @BindView(R.id.popular_show_vote_average)
    TextView showVoteAverage;
    private Context context;
    private PopularShowsPresenter presenter;
    private Show show;

    PopularShowsHolder(Context context, View itemView, PopularShowsPresenter presenter) {
        super(itemView);
        this.context = context;
        this.presenter = presenter;
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    void showImage(String imageUrl) {
        Glide.with(context).load(IMAGE_PATH + imageUrl)
                .dontAnimate()
                .placeholder(R.drawable.placeholder)
                .into(showImage);
    }

    void showTitle(String title) {
        showTitle.setText(title);
    }

    void showVoteAverage(String voteAverage) {
        showVoteAverage.setText(voteAverage);
    }

    void setItem(Show show) {
        this.show = show;
    }

    @Override
    public void onClick(View view) {
        presenter.onShowSelected(show);
    }
}
