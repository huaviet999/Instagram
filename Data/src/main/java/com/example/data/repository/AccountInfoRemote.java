package com.example.data.repository;

import com.example.data.entity.UserEntity;

import io.reactivex.Completable;
import io.reactivex.Maybe;

public interface AccountInfoRemote {
    Completable saveUserAccountInfo(String userId, String username, String fullname, String email);
    Maybe<UserEntity> getUserAccountInfo(String userId);
}
