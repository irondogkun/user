package com.pgleon.user.utility.enums;

/**
 * Description 成功失败枚举类
 * Created by Zev.Sun on 2016/11/29.
 */
public enum EnumIsErrorMsg {
    GetUserIdError("100013", "get userId by token error", "根据token获取userId失败"),
    TokenLoseEfficacy("100014", "Token Lose Efficacy", "token失效");

    private final String code;
    private final String type;
    private final String info;

    private EnumIsErrorMsg(String code, String type, String info) {
        this.code = code;
        this.type = type;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }
}