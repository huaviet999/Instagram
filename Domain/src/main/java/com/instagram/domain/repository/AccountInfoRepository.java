package com.instagram.domain.repository;

import com.instagram.domain.model.User;

import io.reactivex.Completable;

public interface AccountInfoRepository {
    Completable saveUserAccountInfo(String userId, String username, String fullname, String email);
}
