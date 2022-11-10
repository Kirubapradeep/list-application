package com.excercise.feedlist;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.excercise.feedlist.model.ListItem;
import com.excercise.feedlist.presenter.ListDemoPresenter;
import com.excercise.feedlist.presenter.ListDemoPresenterImpl;

import java.util.List;

import butterknife.ButterKnife;

public class ListDemoActivity extends AppCompatActivity implements ListDemoView,
        SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView mListView;
    private RelativeLayout mRootView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    ProgressBar mProgressBar = null;

    private ListDemoPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.loading);

        ButterKnife.setDebug(true);
        ButterKnife.bind(this);

        mListView = (RecyclerView) findViewById(R.id.demo_list);
        mRootView = (RelativeLayout) findViewById(R.id.rootview);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.pull_to_refresh);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mListView.setLayoutManager(layoutManager);

        mSwipeRefreshLayout.setOnRefreshListener(this);

        mPresenter = new ListDemoPresenterImpl(this);
        //Load the Data
         mPresenter.requestData();
         mSwipeRefreshLayout.setRefreshing(true);
     }

    /*
     * Set Title for the View
     */

    @Override
    public void setTitle(String title) {
        setTitle((CharSequence) title);
    }

    /*
     * Populate the Data
     */
    @Override
    public void populateData(List<ListItem> data) {

        if (getBaseContext() != null  && !isFinishing()) {
            mSwipeRefreshLayout.setRefreshing(false);
            RecyclerView.Adapter adapter = new ListDemoAdapter(data, this);
            mListView.setAdapter(adapter);
        }
    }

    /*
     * Show Error in case of Failure
     */
    @Override
    public void showError(String errorMessage) {
        if (getBaseContext() != null  && !isFinishing()) {
            mSwipeRefreshLayout.setRefreshing(false);
            Snackbar.make(mRootView, errorMessage, Snackbar.LENGTH_LONG)
                    .setAction(R.string.retry, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mPresenter.requestData();
                        }
                    })
                    .show();
        }
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onRefresh() {
        mPresenter.refreshData();
    }
}
