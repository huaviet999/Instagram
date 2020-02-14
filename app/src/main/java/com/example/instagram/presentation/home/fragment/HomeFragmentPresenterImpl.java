package com.example.instagram.presentation.home.fragment;

import javax.inject.Inject;

public class HomeFragmentPresenterImpl implements HomeFragmentContract.Presenter {
    @Inject
    public HomeFragmentPresenterImpl() {
    }

    HomeFragmentContract.View mView;

    @Override
    public void takeView(HomeFragmentContract.View view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }
}
