package com.example.instagram.presentation.home;

import com.example.instagram.presentation.home.fragment.HomeFragment;
import com.example.instagram.presentation.home.fragment.HomeFragmentContract;
import com.example.instagram.presentation.home.fragment.HomeFragmentPresenterImpl;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomeModule {
    @ContributesAndroidInjector
    abstract HomeFragment homeFragment();

    @Binds
    public abstract HomeFragmentContract.Presenter homeFragmentPresenter(HomeFragmentPresenterImpl presenter);
    @Binds
    public abstract HomeContract.Presenter homePresenter(HomePresenterImpl presenter);
}
