package com.galenframework.java.sample.api;

import java.util.ArrayList;

public class Result {
    private String ContentTypeLabel;
    private Long Total;
    private Long TotalResults;
    private ArrayList<Item> Items;

    public String getContentTypeLabel() {
        return ContentTypeLabel;
    }

    public Long getTotal() {
        return Total;
    }

    public Long getTotalResults() {
        return TotalResults;
    }

    public ArrayList<Item> getItems() {
        return Items;
    }
}
