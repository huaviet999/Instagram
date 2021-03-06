package com.example.instagram.di;

import com.example.instagram.myapp.MyApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

@Singleton
@Component(modules = {AndroidInjectionModule.class,AppModule.class,AppBindingModule.class, DataModule.class , RemoteModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
        void inject(MyApp instance);

        @Component.Builder
        interface Builder{
            AppComponent build();

            @BindsInstance
            Builder application(MyApp application);
        }

}
