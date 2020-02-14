package com.example.instagram.presentation.login;

import com.example.instagram.presentation.base.BasePresenter;
import com.example.instagram.presentation.base.BaseView;

public interface LoginContract {
    interface View extends BaseView {
        void onSignInSuccess();

        void onSignInFailed();
    }

    interface Presenter extends BasePresenter<View> {
        void login(String username, String password);
    }
}
