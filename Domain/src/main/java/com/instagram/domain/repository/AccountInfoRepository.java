package com.instagram.domain.repository;

import com.instagram.domain.model.User;

import io.reactivex.Completable;
import io.reactivex.Maybe;

public interface AccountInfoRepository {
    Completable saveUserAccountInfo(String userId, String username, String fullname, String email);
    Maybe<User> getUserAccountInfo(String userId);
}
