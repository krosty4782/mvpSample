package com.example.challenge.detail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.challenge.R;
import com.example.challenge.popular.model.Film;

public class DetailFilmActivity extends AppCompatActivity {

    private static final String EXTRA_FILM = "extra_film";

    public static Intent createIntent(Context context, Film film) {
        Intent intent = new Intent(context, DetailFilmActivity.class);
        intent.putExtra(EXTRA_FILM, film);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);
    }
}
