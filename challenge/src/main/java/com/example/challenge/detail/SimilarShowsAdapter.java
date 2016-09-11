package com.example.challenge.detail;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.challenge.R;
import com.example.challenge.popular.model.Show;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.challenge.popular.PopularShowsHolder.IMAGE_PATH;

/**
 * Created by mfolcini on 11/09/2016.
 */

public class SimilarShowsAdapter extends PagerAdapter {

    private Context context;
    private List<Show> shows;

    @BindView(R.id.similar_show_title)
    TextView showTitle;

    @BindView(R.id.similar_show_poster)
    ImageView showPoster;

    @BindView(R.id.similar_show_overview)
    TextView showOverview;

    @BindView(R.id.similar_show_popularity)
    TextView showPopularity;

    public SimilarShowsAdapter(Context context, List<Show> shows) {
        this.context = context;
        this.shows = shows;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        View view = View.inflate(context, R.layout.item_similar_show, null);
        ButterKnife.bind(this, view);
        configureView(shows.get(position));
        collection.addView(view);
        return view;
    }

    private void configureView(Show show) {
        showTitle.setText(show.getOriginalTitle());
        showOverview.setText(show.getOverview());
        showPopularity.setText(String.format("%s %s",
                context.getString(R.string.show_popularity),
                Float.toString(show.getPopularity())));
        Glide.with(context).load(IMAGE_PATH + show.getPosterPath())
                .dontAnimate()
                .dontTransform()
                .placeholder(R.drawable.placeholder)
                .into(showPoster);
    }

    @Override
    public int getCount() {
        return shows.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }
}

