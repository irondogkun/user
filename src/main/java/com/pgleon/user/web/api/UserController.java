package com.pgleon.user.web.api;


import com.pgleon.user.domain.pojo.LoginResult;
import com.pgleon.user.service.IUserService;
import com.pgleon.user.service.LoginArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:用户管理模块接口
 * Created by Zev.Sun on 2016/11/28.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     * @param loginArgs
     * @return
     * @throws Exception
     */
    @PostMapping("login")
    public Object login(@RequestBody LoginArgs loginArgs, HttpServletRequest request) throws Exception {
//        if(!Strings.isNullOrEmpty(loginArgs.getUserName()) && loginArgs.getUserName().contains("_admin") )
//            return adminAccountLogin(loginArgs,request);
        return commonLogin(loginArgs,request);
    }

    /**
     * 普通用户登录
     * @param loginArgs
     * @return
     * @throws Exception
     */
    public LoginResult commonLogin(LoginArgs loginArgs, HttpServletRequest request)throws Exception {

        return userService.login(loginArgs,request);
    }


}