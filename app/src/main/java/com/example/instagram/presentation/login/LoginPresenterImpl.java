package com.example.instagram.presentation.login;

import javax.inject.Inject;

public class LoginPresenterImpl implements LoginContract.Presenter {
    @Inject
    public LoginPresenterImpl(){}
    LoginContract.View mView;
    @Override
    public void takeView(LoginContract.View view) {
            mView = view;
    }

    @Override
    public void dropView() {
            mView = null;
    }

    @Override
    public void login(String username, String password) {
        if(username.equals("viet") && password.equals("123")){
            mView.onSignInSuccess();
        } else {
            mView.onSignInFailed();
        }
    }
}
