package com.excercise.feedlist.presenter;

import com.excercise.feedlist.ListDemoView;
import com.excercise.feedlist.model.ListData;
import com.excercise.feedlist.model.ListDemoModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pradeepraj-ext on 27-04-2016.
 */
public class ListDemoPresenterImpl implements ListDemoPresenter, Callback<ListData> {

    private final ListDemoView mView;
    private final ListDemoModel mModel;

    public ListDemoPresenterImpl(ListDemoView view) {
        mView = view;
        mModel = new ListDemoModel();
    }


    @Override
    public void requestData() {
        mView.showLoading();
        mModel.getListData(this);
    }

    @Override
    public void refreshData() {
        mModel.getListData(this);
    }

    @Override
    public void onResponse(Call<ListData> call, Response<ListData> response) {
        /*
         * Populate the View with the Data once the response is successful
         */
        if (response.isSuccessful()) {
            mView.setTitle(response.body().getTitle());
            mView.populateData(response.body().getRows());
        } else {
            mView.showError(response.message());
        }
        mView.hideLoading();
    }

    @Override
    public void onFailure(Call<ListData> call, Throwable throwable) {
        /*
         * Show Error on failure
         */

        mView.showError(throwable.getMessage());
    }
}
