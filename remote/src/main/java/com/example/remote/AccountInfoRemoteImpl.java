package com.example.remote;

import android.util.Log;

import com.example.data.entity.UserEntity;
import com.example.data.repository.AccountInfoRemote;
import com.example.remote.mapper.UserAccountMapper;
import com.example.remote.model.UserAccountModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import javax.inject.Inject;

import durdinapps.rxfirebase2.RxFirebaseDatabase;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.functions.Function;

public class AccountInfoRemoteImpl implements AccountInfoRemote {

    private static final String TAG = AccountInfoRemoteImpl.class.getSimpleName();
    DatabaseReference firebaseDatabase;

    @Inject
    public AccountInfoRemoteImpl(DatabaseReference databaseReference) {
        this.firebaseDatabase = databaseReference;
    }

    @Override
    public Completable saveUserAccountInfo(String userId, String username, String fullname, String email) {
        DatabaseReference databaseReference = firebaseDatabase.child(Constants.KEY_USERS).child(userId);
        UserAccountMapper userAccountMapper = new UserAccountMapper();
        return RxFirebaseDatabase.setValue(databaseReference, userAccountMapper.mapToModel(userId, username, fullname, email));

    }

    @Override
    public Maybe<UserEntity> getUserAccountInfo(String userId) {
        Log.e(TAG,userId);
        Query query = firebaseDatabase.child(Constants.KEY_USERS).child(userId);
        return RxFirebaseDatabase.observeSingleValueEvent(query, new Function<DataSnapshot, UserEntity>() {
            @Override
            public UserEntity apply(DataSnapshot dataSnapshot) throws Exception {

                UserAccountModel userAccountModel = dataSnapshot.getValue(UserAccountModel.class);
                Log.e(TAG,userAccountModel.toString());
                return new UserAccountMapper().mapFromModel(userAccountModel);
            }
        });
    }
}
