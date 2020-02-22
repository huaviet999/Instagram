package com.example.instagram.di;


import com.example.instagram.presentation.add.AddActivity;
import com.example.instagram.presentation.add.AddModule;
import com.example.instagram.presentation.home.HomeActivity;
import com.example.instagram.presentation.home.HomeModule;
import com.example.instagram.presentation.login.LoginActivity;
import com.example.instagram.presentation.login.LoginModule;
import com.example.instagram.presentation.register.RegisterActivity;
import com.example.instagram.presentation.register.RegisterModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AppBindingModule {
    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity loginActivity();

    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity homeActivity();

    @ContributesAndroidInjector(modules = RegisterModule.class)
    abstract RegisterActivity registerActivity();

    @ContributesAndroidInjector(modules = AddModule.class)
    abstract AddActivity addActivity();
}
