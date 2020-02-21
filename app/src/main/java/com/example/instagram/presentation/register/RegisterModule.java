package com.example.instagram.presentation.register;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RegisterModule {
    @Binds
    public abstract RegisterContract.Presenter resgisterPresenter(RegisterPresenterImpl presenter);
}
