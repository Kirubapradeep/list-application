package com.excercise.feedlist.model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pradeepraj-ext on 27-04-2016.
 */
/*package*/ interface ListDemoService {
    // The API we will be integrating with has a URL for retrieving all of the data for
    // List on the lot
    @GET("u/746330/facts.json")
    Call<ListData> getData();
}
