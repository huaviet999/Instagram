package com.example.instagram.di;

import com.example.data.AccountInfoRepositoryImpl;
import com.example.data.AuthenticationRepositoryImpl;
import com.instagram.domain.repository.AccountInfoRepository;
import com.instagram.domain.repository.AuthenticationRepository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DataModule {
    @Binds
    public abstract AuthenticationRepository bindAuthenticationRepository(AuthenticationRepositoryImpl impl);

    @Binds
    public abstract AccountInfoRepository bindAccountInfoRepository(AccountInfoRepositoryImpl impl);
}
