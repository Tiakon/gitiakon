package com.tiakon.entity;

/**
 * Created by Hoictas on 2017/8/8.
 */
public class User {
    private int userId;
    private String userName;
    private String password;
    private String nickName;
    private String imageName;
    private String mood;

    public User() {
    }

    public User(int userId, String userName, String password, String nickName, String imageName, String mood) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.imageName = imageName;
        this.mood = mood;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", imageName='" + imageName + '\'' +
                ", mood='" + mood + '\'' +
                '}';
    }
}
