package com.excercise.feedlist.model;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pradeepraj-ext on 27-04-2016.
 */
public class ListDemoModel {

    /*
     * URL
     */
    private static final String BASE_URL = "https://dl.dropboxusercontent.com/";

    private final ListDemoService mService;

    public ListDemoModel() {
        /*
         * Retrofit is the class through which your API interfaces are turned into callable objects.
         * By default, Retrofit will give you sane defaults for your platform but it allows for
         * customization
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService = retrofit.create(ListDemoService.class);
    }

    /*
     * Get the List of Data from the Url using Retrofit
     */

    public void getListData(Callback<ListData> callback) {
        mService.getData().enqueue(callback);
    }
}
