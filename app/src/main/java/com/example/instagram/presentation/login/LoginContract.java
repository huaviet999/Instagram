package com.example.instagram.presentation.login;

import com.example.instagram.presentation.base.BasePresenter;

public interface LoginContract {
    interface View {
            void onSignInSuccess();
            void onSignInFailed();
    }

    interface Presenter extends BasePresenter<View> {
            void login(String username,String password);
    }
}
