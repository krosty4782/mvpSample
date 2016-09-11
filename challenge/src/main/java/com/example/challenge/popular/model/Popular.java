package com.example.challenge.popular.model;

import java.util.List;

/**
 * Created by mfolcini on 10/09/2016.
 */

public class Popular {

    private int page;
    private List<Show> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Show> getResults() {
        return results;
    }

    public void setResults(List<Show> results) {
        this.results = results;
    }
}
