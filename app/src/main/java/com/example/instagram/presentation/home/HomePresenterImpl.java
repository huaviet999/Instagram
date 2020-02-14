package com.example.instagram.presentation.home;

import javax.inject.Inject;

public class HomePresenterImpl implements HomeContract.Presenter {
    @Inject
    public HomePresenterImpl() {
    }

    HomeContract.View mView;

    @Override
    public void takeView(HomeContract.View view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }
}
