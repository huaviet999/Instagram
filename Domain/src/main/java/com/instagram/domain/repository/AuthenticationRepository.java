package com.instagram.domain.repository;

import com.instagram.domain.MaybeUseCase;
import com.instagram.domain.model.User;

import io.reactivex.Maybe;


public interface AuthenticationRepository {
    Maybe<User> registerAccount(String username, String fullname, String email, String password);
}
