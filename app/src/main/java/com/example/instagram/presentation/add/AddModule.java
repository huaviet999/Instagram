package com.example.instagram.presentation.add;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AddModule {
    @Binds
    public abstract AddContract.Presenter bindAddPresenter(AddPresenterImpl presenter);
}
