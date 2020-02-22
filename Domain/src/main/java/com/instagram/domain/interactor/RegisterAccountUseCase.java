package com.instagram.domain.interactor;

import com.instagram.domain.MaybeUseCase;
import com.instagram.domain.executor.ExecutionThread;
import com.instagram.domain.model.User;
import com.instagram.domain.repository.AccountInfoRepository;
import com.instagram.domain.repository.AuthenticationRepository;

import javax.inject.Inject;

import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;


public class RegisterAccountUseCase extends MaybeUseCase<RegisterAccountUseCase.Param> {
    AuthenticationRepository authenticationRepository;
    AccountInfoRepository accountInfoRepository;

    @Inject
    public RegisterAccountUseCase(ExecutionThread executionThread, AuthenticationRepository authenticationRepository , AccountInfoRepository accountInfoRepository) {
        super(executionThread);
        this.authenticationRepository = authenticationRepository;
        this.accountInfoRepository = accountInfoRepository;
    }

    @Override
    protected Maybe<User> buildUseCase(Param param) {
        return authenticationRepository.registerAccount(param.username, param.fullname, param.email, param.password)
                .flatMap(new Function<User, MaybeSource<? extends User>>() {
                    @Override
                    public MaybeSource<? extends User> apply(User user) throws Exception {
                        return accountInfoRepository.saveUserAccountInfo(user.getUserId(),param.username,param.fullname,user.getEmail()).andThen(Maybe.just(user));
                    }
                });

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
