package com.example.data;

import com.example.data.entity.UserEntity;
import com.example.data.mapper.UserEntityMapper;
import com.example.data.repository.AccountInfoRemote;
import com.instagram.domain.model.User;
import com.instagram.domain.repository.AccountInfoRepository;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.functions.Function;

public class AccountInfoRepositoryImpl implements AccountInfoRepository {
    private static final String TAG = AccountInfoRepositoryImpl.class.getSimpleName();

    AccountInfoRemote accountInfoRemote;

    @Inject
    public AccountInfoRepositoryImpl(AccountInfoRemote accountInfoRemote) {
        this.accountInfoRemote = accountInfoRemote;
    }

    @Override
    public Completable saveUserAccountInfo(String userId, String username, String fullname, String email) {
        return accountInfoRemote.saveUserAccountInfo(userId, username, fullname, email);
    }

    @Override
    public Maybe<User> getUserAccountInfo(String userId) {
        return accountInfoRemote.getUserAccountInfo(userId).map(new Function<UserEntity, User>() {
            @Override
            public User apply(UserEntity userEntity) throws Exception {
                UserEntityMapper userEntityMapper = new UserEntityMapper();
                return userEntityMapper.mapFromEntity(userEntity);
            }
        });
    }
}
