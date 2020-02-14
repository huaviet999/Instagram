package com.example.instagram.presentation.search;

import javax.inject.Inject;

public class SearchFragmentPresenterImpl implements SearchContract.Presenter {
    @Inject
    public SearchFragmentPresenterImpl() {
    }

    SearchContract.View mView;
    @Override
    public void takeView(SearchContract.View view) {
            mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }
}
