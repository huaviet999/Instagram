package com.example.instagram.presentation.profile;

import javax.inject.Inject;

public class ProfileFragmentPresenterImpl implements ProfileContract.Presenter {

    @Inject
    public ProfileFragmentPresenterImpl() {
    }

    ProfileContract.View mView;

    @Override
    public void takeView(ProfileContract.View view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }
}
