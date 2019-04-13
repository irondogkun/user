package com.pgleon.user.domain.pojo;


public class ResetPasswordResult {
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResetPasswordResult{" +
                "result='" + result + '\'' +
                '}';
    }
}
