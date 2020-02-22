package com.example.instagram.presentation.register;

import com.example.instagram.presentation.base.BasePresenter;
import com.example.instagram.presentation.base.BaseView;
import com.instagram.domain.model.User;

public interface RegisterContract {
    interface View extends BaseView {
        void onSignUpSuccess();

        void onSignUpFailed();

        void disableRegisterButtonIfTrue(boolean disable);
    }

    interface Presenter extends BasePresenter<View> {
        void signUp(User user);

        void disableRegisterButtonIfEmpty(CharSequence username, CharSequence fullname, CharSequence email, CharSequence password);
    }
}
