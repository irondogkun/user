package com.pgleon.user.domain.pojo;


public class LoginResult {
    private String token;
    private Integer userId;
    private String phone;
    private Integer validateStatus;
    private String bindType;
    private String bindName;


    public String getBindType() {
        return bindType;
    }

    public void setBindType(String bindType) {
        this.bindType = bindType;
    }

    public String getBindName() {
        return bindName;
    }

    public void setBindName(String bindName) {
        this.bindName = bindName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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

    public Integer getValidateStatus() {
        return validateStatus;
    }

    public void setValidateStatus(Integer validateStatus) {
        this.validateStatus = validateStatus;
    }



    @Override
    public String toString() {
        return "LoginResult{" +
                "token='" + token + '\'' +
                ", userId=" + userId +
                ", phone='" + phone + '\'' +
                ", validateStatus=" + validateStatus +
                ", bindType='" + bindType + '\'' +
                ", bindName='" + bindName + '\'' +
                '}';
    }
}