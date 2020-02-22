package com.instagram.domain.model;

public class User {
    private String userId;
    private String email;
    private String password;
    private String username;
    private String fullName;
    private String profileImage;
    private String bio;

    public User() {
    }

    public User(String userId, String email, String username, String fullName, String profileImage, String bio) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.fullName = fullName;
        this.profileImage = profileImage;
        this.bio = bio;
    }

    public User(String username, String fullName, String email, String password) {
        this.email = email;
        this.username = username;
        this.fullName = fullName;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
