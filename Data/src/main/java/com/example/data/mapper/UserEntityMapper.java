package com.example.data.mapper;

import com.example.data.entity.UserEntity;
import com.instagram.domain.model.User;

public class UserEntityMapper implements BaseMapper<UserEntity, User> {

    @Override
    public UserEntity mapToEntity(User user) {
        return null;
    }

    @Override
    public User mapFromEntity(UserEntity userEntity) {
        User user = new User();
        user.setUsername(userEntity.getUsername());
        user.setEmail(userEntity.getEmail());
        user.setUserId(userEntity.getUserId());
        user.setFullName(userEntity.getFullname());
        return user;
    }
}
