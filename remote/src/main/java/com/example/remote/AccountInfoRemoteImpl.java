package com.example.remote;

import com.example.data.repository.AccountInfoRemote;
import com.example.remote.mapper.UserAccountMapper;
import com.google.firebase.database.DatabaseReference;

import javax.inject.Inject;

import durdinapps.rxfirebase2.RxFirebaseDatabase;
import io.reactivex.Completable;

public class AccountInfoRemoteImpl implements AccountInfoRemote {

    DatabaseReference firebaseDatabase;

    @Inject
    public AccountInfoRemoteImpl(DatabaseReference databaseReference) {
        this.firebaseDatabase = databaseReference;
    }

    @Override
    public Completable saveUserAccountInfo(String userId, String username, String fullname, String email) {
        DatabaseReference databaseReference = firebaseDatabase.child(Constants.KEY_USERS).child(userId);
        UserAccountMapper userAccountMapper = new UserAccountMapper();
        return RxFirebaseDatabase.setValue(databaseReference, userAccountMapper.mapToModel(userId, username, fullname,email));

    }
}
