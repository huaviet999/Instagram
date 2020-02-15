package com.instagram.domain.Model;

public class User {
    private String userId;
    private String userName;
    private String profileImage;

    public User(String userId, String userName, String profileImage) {
        this.userId = userId;
        this.userName = userName;
        this.profileImage = profileImage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", profileImage='" + profileImage + '\'' +
                '}';
    }
}
