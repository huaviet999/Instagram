package com.example.instagram.presentation.add;

import javax.inject.Inject;

public class AddPresenterImpl implements AddContract.Presenter {

    AddContract.View mView;

    @Inject
    public AddPresenterImpl() {
    }

    @Override
    public void takeView(AddContract.View view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }
}
