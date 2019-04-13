package com.pgleon.user.utility.enums;

/**
 * Description 成功失败枚举类
 */
public enum EnumIsSuccess {

    Success(0, "成功"),
    Failed(-1, "失败");

    private final int value;
    private final String info;

    private EnumIsSuccess(int value, String info) {
        this.value = value;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public int getValue() {
        return value;
    }
}
