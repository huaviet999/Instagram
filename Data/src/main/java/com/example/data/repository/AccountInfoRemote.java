package com.example.data.repository;

import io.reactivex.Completable;

public interface AccountInfoRemote {
    Completable saveUserAccountInfo(String userId, String username, String fullname, String email);

}
