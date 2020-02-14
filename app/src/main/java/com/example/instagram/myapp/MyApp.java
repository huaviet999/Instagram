package com.example.instagram.myapp;

import android.app.Application;

import com.example.instagram.di.AppComponent;
import com.example.instagram.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class MyApp extends Application implements HasAndroidInjector {
    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        //Init dagger
        initDagger();
    }

    private AppComponent appComponent;
    public void initDagger(){
        appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
    }
    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }
}
