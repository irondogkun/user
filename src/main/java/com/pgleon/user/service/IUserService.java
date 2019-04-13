package com.pgleon.user.service;


import com.pgleon.user.domain.pojo.LoginArgs;

import javax.servlet.http.HttpServletRequest;

/**
 * Description 用户管理接口层
 */
public interface IUserService {

    /**
     * @Description: 生成token
     * @Param:
     * @Return:
     */
    String createToken();

    /**
     * @Author Leon
     * @Description 管理台登录
     * @Param [loginArgs, request]
     * @return java.lang.Object
     **/
    Object adminLogin(LoginArgs loginArgs, HttpServletRequest request) throws Exception;
}