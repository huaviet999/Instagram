package com.instagram.domain.interactor;

import com.instagram.domain.MaybeUseCase;
import com.instagram.domain.executor.ExecutionThread;
import com.instagram.domain.model.User;
import com.instagram.domain.repository.AuthenticationRepository;

import javax.inject.Inject;

import io.reactivex.Maybe;


public class RegisterAccountUseCase extends MaybeUseCase<RegisterAccountUseCase.Param> {
    AuthenticationRepository authenticationRepository;

    @Inject
    public RegisterAccountUseCase(ExecutionThread executionThread, AuthenticationRepository authenticationRepository) {
        super(executionThread);
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    protected Maybe<User> buildUseCase(Param param) {
        return authenticationRepository.registerAccount(param.username, param.fullname, param.email, param.password);
    }

    public static class Param {
        public String username;
        public String fullname;
        public String email;
        public String password;

        public Param(String username, String fullname, String email, String password) {
            this.username = username;
            this.fullname = fullname;
            this.email = email;
            this.password = password;
        }
    }
}
