package com.example.remote;

import com.example.data.entity.UserEntity;
import com.example.data.repository.AuthenticationRemote;
import com.example.remote.mapper.AuthResultMapper;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

import durdinapps.rxfirebase2.RxFirebaseAuth;
import io.reactivex.Maybe;
import io.reactivex.functions.Function;


public class AuthenticationRemoteImpl implements AuthenticationRemote {
    FirebaseAuth firebaseAuth;

    @Inject
    public AuthenticationRemoteImpl(FirebaseAuth auth){
        firebaseAuth = auth;
    }

    @Override
    public Maybe<UserEntity> registerAccount(String username, String fullname, String email, String password) {
        return RxFirebaseAuth.createUserWithEmailAndPassword(firebaseAuth,email,password)
                .map(new Function<AuthResult, UserEntity>() {
                    @Override
                    public UserEntity apply(AuthResult authResult) throws Exception {
                        AuthResultMapper mapper = new AuthResultMapper();
                        return mapper.mapFromModel(authResult)  ;
                    }
                });

    }
}
