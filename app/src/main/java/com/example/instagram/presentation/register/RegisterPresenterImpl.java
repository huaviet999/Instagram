package com.example.instagram.presentation.register;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.instagram.domain.interactor.RegisterAccountUseCase;
import com.instagram.domain.model.User;

import javax.inject.Inject;

import io.reactivex.observers.DisposableMaybeObserver;


public class RegisterPresenterImpl implements RegisterContract.Presenter {
    private static final String TAG = RegisterPresenterImpl.class.getSimpleName();
    @Inject
    RegisterAccountUseCase registerAccountUseCase;

    @Inject
    public RegisterPresenterImpl() {
    }

    private RegisterContract.View mView;

    @Override
    public void takeView(RegisterContract.View view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mView = null;
    }

    @Override
    public void signUp(String username, String fullname, String email, String password) {
        mView.showProgressDialog();
        registerAccountUseCase.execute(new RegisterAccountObserver(), new RegisterAccountUseCase.Param(username, fullname, email, password));
    }

    @Override
    public void disableRegisterButtonIfEmpty(CharSequence username, CharSequence fullname, CharSequence email, CharSequence password) {
        if (username.toString().isEmpty() || fullname.toString().isEmpty() || email.toString().isEmpty() || password.toString().isEmpty()) {
            mView.disableRegisterButtonIfTrue(true);
        } else {
            mView.disableRegisterButtonIfTrue(false);
        }
    }

    private class RegisterAccountObserver extends DisposableMaybeObserver<User>{
        @Override
        public void onSuccess(User user) {
            mView.hideProgressDialog();
            mView.onSignUpSuccess();
            Log.d(TAG,user.toString());
        }

        @Override
        public void onError(Throwable e) {
            mView.hideProgressDialog();
            mView.onSignUpFailed();
        }

        @Override
        public void onComplete() {

        }
    }
}
