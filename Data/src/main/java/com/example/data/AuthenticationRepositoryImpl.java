package com.example.data;

import com.example.data.entity.UserEntity;
import com.example.data.mapper.UserEntityMapper;
import com.example.data.repository.AuthenticationRemote;
import com.instagram.domain.model.User;
import com.instagram.domain.repository.AuthenticationRepository;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.functions.Function;


public class AuthenticationRepositoryImpl implements AuthenticationRepository {
    AuthenticationRemote authenticationRemote;

    @Inject
    public AuthenticationRepositoryImpl(AuthenticationRemote authenticationRemote) {
        this.authenticationRemote = authenticationRemote;
    }


    @Override
    public Maybe<User> registerAccount(String username, String fullname, String email, String password) {
        return authenticationRemote.registerAccount(username, fullname, email, password)
                .map(new Function<UserEntity, User>() {
                    @Override
                    public User apply(UserEntity userEntity) throws Exception {
                        UserEntityMapper userEntityMapper = new UserEntityMapper();
                        return userEntityMapper.mapFromEntity(userEntity);
                    }
                });
    }

    @Override
    public Maybe<String> loginWithEmailAndPassword(String email, String password) {
        return authenticationRemote.loginWithEmailAndPassword(email,password);
    }
}
