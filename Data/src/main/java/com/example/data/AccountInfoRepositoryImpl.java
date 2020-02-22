package com.example.data;

import com.example.data.repository.AccountInfoRemote;
import com.instagram.domain.repository.AccountInfoRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class AccountInfoRepositoryImpl implements AccountInfoRepository {

    AccountInfoRemote accountInfoRemote;

    @Inject
    public AccountInfoRepositoryImpl(AccountInfoRemote accountInfoRemote) {
        this.accountInfoRemote = accountInfoRemote;
    }

    @Override
    public Completable saveUserAccountInfo(String userId, String username, String fullname, String email) {
        return accountInfoRemote.saveUserAccountInfo(userId, username, fullname,email);
    }
}
