package com.example.remote.mapper;

import com.example.data.entity.UserEntity;
import com.google.firebase.auth.AuthResult;

public class AuthResultMapper implements BaseMapper<AuthResult, UserEntity> {
    @Override
    public AuthResult mapToModel(UserEntity userEntity) {
        return null;
    }

    @Override
    public UserEntity mapFromModel(AuthResult authResult) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(authResult.getUser().getDisplayName());
        userEntity.setEmail(authResult.getUser().getEmail());
        userEntity.setUserId(authResult.getUser().getUid());
        return userEntity;
    }
}
