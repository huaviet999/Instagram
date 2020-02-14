package com.example.instagram.presentation.login;

import com.example.instagram.presentation.base.BasePresenter;
import com.example.instagram.presentation.base.BaseView;

public interface LoginContract {
    interface View extends BaseView {
        void onSignInSuccess();
        void onSignInFailed();
        void disableLoginButtonIfTrue(boolean disable);
    }

    interface Presenter extends BasePresenter<View> {
        void login(String username, String password);
        void disableLoginButtonIfEmpty(CharSequence username,CharSequence password);
    }
}
