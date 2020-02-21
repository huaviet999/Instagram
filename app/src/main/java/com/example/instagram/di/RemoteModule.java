package com.example.instagram.di;

import com.example.data.repository.AuthenticationRemote;
import com.example.remote.AuthenticationRemoteImpl;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Viet Hua on 2/21/2020
 */
@Module
public abstract class RemoteModule {
    @Binds
    public abstract AuthenticationRemote bindAuthenticationRemote(AuthenticationRemoteImpl impl);
}
