package com.example.instagram.presentation.login;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class LoginModule {
    @Binds
    public abstract LoginContract.Presenter loginPresenter(LoginPresenterImpl presenter);
}
