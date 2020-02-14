package com.example.instagram.presentation.home;

import com.example.instagram.presentation.favorite.FavoriteContract;
import com.example.instagram.presentation.favorite.FavoriteFragment;
import com.example.instagram.presentation.favorite.FavoriteFragmentPresenterImpl;
import com.example.instagram.presentation.home.fragment.HomeFragment;
import com.example.instagram.presentation.home.fragment.HomeFragmentContract;
import com.example.instagram.presentation.home.fragment.HomeFragmentPresenterImpl;
import com.example.instagram.presentation.profile.ProfileContract;
import com.example.instagram.presentation.profile.ProfileFragment;
import com.example.instagram.presentation.profile.ProfileFragmentPresenterImpl;
import com.example.instagram.presentation.search.SearchContract;
import com.example.instagram.presentation.search.SearchFragment;
import com.example.instagram.presentation.search.SearchFragmentPresenterImpl;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomeModule {
    @ContributesAndroidInjector
    abstract HomeFragment homeFragment();

    @ContributesAndroidInjector
    abstract SearchFragment searchFragment();

    @ContributesAndroidInjector
    abstract FavoriteFragment favoriteFragment();

    @ContributesAndroidInjector
    abstract ProfileFragment profileFragment();

    @Binds
    public abstract HomeFragmentContract.Presenter homeFragmentPresenter(HomeFragmentPresenterImpl presenter);

    @Binds
    public abstract HomeContract.Presenter homePresenter(HomePresenterImpl presenter);

    @Binds
    public abstract SearchContract.Presenter searchFragmentPresenter(SearchFragmentPresenterImpl presenter);

    @Binds
    public abstract FavoriteContract.Presenter favoriteFragmentPresenter(FavoriteFragmentPresenterImpl presenter);

    @Binds
    public abstract ProfileContract.Presenter profileFragmentPresenter(ProfileFragmentPresenterImpl presenter);
}
