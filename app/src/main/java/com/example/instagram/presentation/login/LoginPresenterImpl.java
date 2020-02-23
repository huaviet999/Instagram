package com.example.instagram.presentation.login;

import android.util.Log;

import com.instagram.domain.interactor.LoginUseCase;
import com.instagram.domain.model.User;

import javax.inject.Inject;

import io.reactivex.observers.DisposableMaybeObserver;

public class LoginPresenterImpl implements LoginContract.Presenter {
    private static final String TAG = LoginPresenterImpl.class.getSimpleName();
    @Inject
    LoginUseCase loginUseCase;

    @Inject
    public LoginPresenterImpl() {
    }

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
        loginUseCase.execute(new LoginObserver(), new LoginUseCase.Param(username, password));
    }

    @Override
    public void disableLoginButtonIfEmpty(CharSequence username, CharSequence password) {
        if (username.toString().isEmpty() || password.toString().isEmpty()) {
            mView.disableLoginButtonIfTrue(true);
        } else {
            mView.disableLoginButtonIfTrue(false);
        }
    }

    private class LoginObserver extends DisposableMaybeObserver<User> {
        @Override
        public void onSuccess(User user) {
            Log.d(TAG, user.toString());
            mView.hideProgressDialog();
            mView.onSignInSuccess();
        }

        @Override
        public void onError(Throwable e) {
            mView.hideProgressDialog();
            mView.onSignInFailed();
        }

        @Override
        public void onComplete() {

        }
    }
}
