package com.example.instagram.di;

import android.content.Context;

import com.example.instagram.myapp.MyApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.instagram.domain.executor.ExecutionThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    @Singleton
    public Context provideContext(MyApp myApp) {
        return myApp;
    }

    @Provides
    @Singleton
    public ExecutionThread provideExecutionThread() {
        return new ExecutionThreadImpl();
    }

    @Provides
    @Singleton
    public FirebaseAuth provideAuthenticationReference() {
        return FirebaseAuth.getInstance();
    }


    @Provides
    @Singleton
    public DatabaseReference provideFirebaseDatabaseReference() {
        return FirebaseDatabase.getInstance().getReference();
    }

}
