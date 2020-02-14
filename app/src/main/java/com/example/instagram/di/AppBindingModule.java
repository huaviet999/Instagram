package com.example.instagram.di;



import com.example.instagram.presentation.login.LoginActivity;
import com.example.instagram.presentation.login.LoginModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AppBindingModule {
    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity loginActivity();
}
