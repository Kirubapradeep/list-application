package com.excercise.feedlist.model;

/**
 * Created by pradeepraj-ext on 27-04-2016.
 */
public class ListItem {
    // Title String for the Row item
    private String title;

    // Description String for the Row item
    private String description;

    // imageHref url for the Row item
    private String imageHref;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageHref() {
        return imageHref;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageHref='" + imageHref + '\'' +
                '}';
    }
}
