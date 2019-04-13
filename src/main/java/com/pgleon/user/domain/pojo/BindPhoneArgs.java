package com.pgleon.user.domain.pojo;

/**
 * Created by leon on 2019-04-11 16:09
 */
public class BindPhoneArgs {
    private static final String NoEnoughArgs = "1";
    private static final String AlreadyUsed = "2";
    private static final String BindSuccess = "3";
    private static final String BindFail = "4";

    private Integer userId;
    private String updType;
    private String updContent;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUpdType() {
        return updType;
    }

    public void setUpdType(String updType) {
        this.updType = updType;
    }

    public String getUpdContent() {
        return updContent;
    }

    public void setUpdContent(String updContent) {
        this.updContent = updContent;
    }

    @Override
    public String toString() {
        return "BindPhoneArgs{" +
                "userId='" + userId + '\'' +
                ", updType='" + updType + '\'' +
                ", updContent='" + updContent + '\'' +
                '}';
    }
}
