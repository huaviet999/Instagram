package com.instagram.domain.interactor;

import com.instagram.domain.MaybeUseCase;
import com.instagram.domain.executor.ExecutionThread;
import com.instagram.domain.repository.AccountInfoRepository;
import com.instagram.domain.repository.AuthenticationRepository;

import javax.inject.Inject;

import io.reactivex.Maybe;

public class LoginUseCase extends MaybeUseCase<LoginUseCase.Param> {

    AuthenticationRepository authenticationRepository;
    AccountInfoRepository accountInfoRepository;
    @Inject
    public LoginUseCase(ExecutionThread executionThread, AuthenticationRepository authenticationRepository, AccountInfoRepository accountInfoRepository){
        super(executionThread);
        this.authenticationRepository = authenticationRepository;
        this.accountInfoRepository = accountInfoRepository;
    }

    @Override
    protected Maybe buildUseCase(Param param) {
        return authenticationRepository.loginWithEmailAndPassword(param.email,param.password);
    }

    public static class Param{
        public String email;
        public String password;

        public Param(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }
}
