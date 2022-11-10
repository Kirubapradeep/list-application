package com.excercise.feedlist.model;

import java.util.List;

/**
 * Created by pradeepraj-ext on 27-04-2016.
 */
public class ListData {

    //Title
    private String title;

    //List of rows json contents
    private List<ListItem> rows;

    public String getTitle() {
        return title;
    }

    public List<ListItem> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return "ListData{" +
                "title='" + title + '\'' +
                ", rows=" + rows +
                '}';
    }
}
