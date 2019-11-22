package com.galenframework.java.sample.api;

import java.util.ArrayList;

public class SearchResults {

    private String Query;
    private Long SearchResultCount;
    private ArrayList<Result> Results;

    public String getQuery() {
        return Query;
    }

    public Long getSearchResultCount() {
        return SearchResultCount;
    }

    public ArrayList<Result> getResults() {
        return Results;
    }
}
