package com.pgleon.user.domain.pojo.admin;/**
 * Created by leon on 2019-04-13 17:26
 */

/**
 * @Auther: leon
 * @Date: 2019-04-13 17:26
 * @Description:
 */
public class AdminLoginResult {
    private String token;
    private Integer userId;
    private String userName;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
