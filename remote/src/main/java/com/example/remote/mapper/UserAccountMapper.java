package com.example.remote.mapper;

import com.example.data.entity.UserEntity;
import com.example.remote.model.UserAccountModel;

public class UserAccountMapper implements BaseMapper<UserAccountModel, UserEntity> {
    @Override
    public UserAccountModel mapToModel(UserEntity userEntity) {
        return null;
    }

    @Override
    public UserEntity mapFromModel(UserAccountModel userAccountModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userAccountModel.getUserId());
        userEntity.setUsername(userAccountModel.getUsername());
        userEntity.setFullname(userAccountModel.getFullname());
        userEntity.setEmail(userAccountModel.getEmail());
        return userEntity;
    }

    public UserAccountModel mapToModel(String userId, String username, String fullname, String email) {
        UserAccountModel userAccountModel = new UserAccountModel();
        userAccountModel.setUserId(userId);
        userAccountModel.setUsername(username);
        userAccountModel.setFullname(fullname);
        userAccountModel.setEmail(email);
        return userAccountModel;
    }
}
