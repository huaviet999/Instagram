package com.example.instagram.presentation.login;

import com.instagram.domain.interactor.LoginUseCase;

import javax.inject.Inject;

import io.reactivex.observers.DisposableMaybeObserver;

public class LoginPresenterImpl implements LoginContract.Presenter {
    @Inject
    LoginUseCase loginUseCase;
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
        mView.showProgressDialog();
       loginUseCase.execute(new LoginObserver(),new LoginUseCase.Param(username,password));
    }

    @Override
    public void disableLoginButtonIfEmpty(CharSequence username,CharSequence password) {
        if(username.toString().isEmpty() || password.toString().isEmpty()){
            mView.disableLoginButtonIfTrue(true);
        } else{
            mView.disableLoginButtonIfTrue(false);
        }
    }
    private class LoginObserver extends DisposableMaybeObserver{
        @Override
        public void onSuccess(Object o) {
            mView.hideProgressDialog();
            mView.onSignInSuccess();
        }

        @Override
        public void onError(Throwable e) {
            mView.onSignInFailed();
        }

        @Override
        public void onComplete() {

        }
    }
}
