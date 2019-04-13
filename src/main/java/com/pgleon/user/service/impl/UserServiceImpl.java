package com.pgleon.user.service.impl;

import com.pgleon.rpcapi.user.pojo.ValidatePhone;
import com.pgleon.user.domain.mapper.UserMapper;
import com.pgleon.user.domain.pojo.*;
import com.pgleon.user.domain.pojo.admin.AdminLoginResult;
import com.pgleon.user.service.IUserService;
import com.pgleon.user.domain.pojo.LoginArgs;
import com.pgleon.user.service.UserApiException;
import com.pgleon.user.utility.enums.EnumIsErrorMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Description:用户管理模块接口实现层
 */
@CacheConfig(cacheNames = "user")
@Service
public class UserServiceImpl implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    /**
     * @Description: 生成token
     * @Param:
     * @Return:
     */
    @Override
    public String createToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * @param loginArgs
     * @param request
     * @return java.lang.Object
     * @Author Leon
     * @Description 管理台登录
     * @Param [loginArgs, request]
     */
    @Override
    public Object adminLogin(LoginArgs loginArgs, HttpServletRequest request) throws Exception {
        String appId = org.apache.logging.log4j.util.Strings.isEmpty(request.getParameter("app_id")) ? "" : request.getParameter("app_id");
        Account account = userMapper.adminLogin(loginArgs);

        if (account == null) {
            //登陆失败
            throw new UserApiException.insiApLoginException("用户名或密码错误");
        }
        //登录成功
        String token = createToken();
        //保存token 与userId
        putUserIdAndToken(account.getUserId(), token,appId,"","");
        AdminLoginResult adminLoginResult = new AdminLoginResult();
        adminLoginResult.setToken(token);
        adminLoginResult.setUserId(account.getUserId());
        adminLoginResult.setUserName(account.getUserName());
        return adminLoginResult;
    }
    /**
     * @Description: 用户登录成功后为该用户分配一个Token（uuid），并将Token和userId关联关系存储。
     * 放入redis缓存
     * @Param: userId 登录成功用户id
     * @Return: token 为该用户分配的token
     */
    @CachePut(key = "#token")
    public int putUserIdAndToken(int userId, String token,String appId,String deviceId,String deviceName) throws Exception {
        int i = 0;
        try {
            i = userMapper.insertUserIdAndToken(userId, token, appId, deviceId, deviceName);
        } catch (Exception e) {
            logger.error("保存 token 与 userId 关系过程中出现异常", e, userId, token);
            throw new UserApiException.InternalServerException("保存 token 与 userId 关系过程中出现异常");
        }
        if (i != 1) {
            logger.error("保存 token 与 userId 关系失败", userId, token);
            throw new UserApiException.InternalServerException("保存 token 与 userId 关系失败");
        }

        return userId;
    }

}