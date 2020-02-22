package com.example.data.repository;

import com.example.data.entity.UserEntity;

import io.reactivex.Maybe;


public interface AuthenticationRemote {
    Maybe<UserEntity> registerAccount(String username, String fullname, String email, String password);
    Maybe<String> loginWithEmailAndPassword(String email,String password);
}
