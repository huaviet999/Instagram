package com.example.instagram.presentation.favorite;

import javax.inject.Inject;

public class FavoriteFragmentPresenterImpl implements FavoriteContract.Presenter {
    @Inject
    public FavoriteFragmentPresenterImpl(){}

    FavoriteContract.View mView;

    @Override
    public void takeView(FavoriteContract.View view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }
}
