package com.pgleon.user.utility.enums;

/**
 * Description 成功失败枚举类
 */
public enum EnumLoninMsg {
    LoginSuccess(3, "登录成功"),
    LoginNoUserName(1, "用户名不存在"),
    LoginWrongPassword(2, "密码错误");

    private final int code;
    private final String info;

    private EnumLoninMsg(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public int getCode() {
        return code;
    }
}