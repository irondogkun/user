package com.pgleon.user.domain.pojo;

public class ResetPasswordArgs {
    private String userName;
    private String newPassWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNewPassWord() {
        return newPassWord;
    }

    public void setNewPassWord(String newPassWord) {
        this.newPassWord = newPassWord;
    }

    @Override
    public String toString() {
        return "ResetPasswordArgs{" +
                "userName='" + userName + '\'' +
                ", newPassWord='" + newPassWord + '\'' +
                '}';
    }
}