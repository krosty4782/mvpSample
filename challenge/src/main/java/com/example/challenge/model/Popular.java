package com.example.challenge.model;

import java.util.List;

/**
 * Created by mfolcini on 10/09/2016.
 */

public class Popular {

    private int page;
    private List<Film> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Film> getResults() {
        return results;
    }

    public void setResults(List<Film> results) {
        this.results = results;
    }
}
