package com.excercise.feedlist;

import com.excercise.feedlist.model.ListItem;

import java.util.List;

/**
 * Created by pradeepraj-ext on 27-04-2016.
 */
public interface ListDemoView {

    void setTitle(String title);
    void populateData(List<ListItem> data);
    void showError(String errorMessage);
    void showLoading();
    void hideLoading();
}
