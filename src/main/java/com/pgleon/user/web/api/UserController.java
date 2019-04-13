package com.pgleon.user.web.api;


import com.google.common.base.Strings;
import com.pgleon.user.service.IUserService;
import com.pgleon.user.domain.pojo.LoginArgs;
import com.pgleon.user.service.UserApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

   /**
    * @Author Leon
    * @Description 管理台登录
    * @Param [loginArgs, request]
    * @return java.lang.Object
    **/
    @PostMapping("/admin/login")
    public Object login(@RequestBody LoginArgs loginArgs, HttpServletRequest request) throws Exception {
        if (loginArgs == null || Strings.isNullOrEmpty(loginArgs.getUserName())
                || Strings.isNullOrEmpty(loginArgs.getPassword())) {
            throw new UserApiException.noEnoughArgsException("缺少必要参数");
        }
        return userService.adminLogin(loginArgs,request);
    }



}