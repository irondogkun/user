package com.pgleon.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.pgleon.rpcapi.user.pojo.ValidatePhone;
import com.pgleon.user.domain.mapper.UserMapper;
import com.pgleon.user.domain.pojo.*;
import com.pgleon.user.service.IUserService;
import com.pgleon.user.service.LoginArgs;
import com.pgleon.user.service.UserApiException;
import com.pgleon.user.utility.enums.EnumIsErrorMsg;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
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
     * @Description: 登录接口
     * @Param:
     * @Return:
     */
    @Override
    public LoginResult login(LoginArgs loginArgs, HttpServletRequest request) throws Exception {
        return null;
    }

    /**
     * @param token
     * @param userId
     * @Description: 退出登录接口
     * @Param:
     * @Return:
     */
    @Override
    public Object logout(String token, int userId) throws Exception {
        return null;
    }

    /**
     * @Description: 根据用户token获取用户id
     * @Param: token 值
     * @Return: 正常userId作为主键都>0，当token失效返回-1 ，运行过程中出异常返回-2。
     */
    @Cacheable(key = "#token")
    public Integer getUserIdByToken(String token) {
        try {
            Integer userId = userMapper.selectUserIdByToken(token);
            if (userId == null) {
                //token失效
                logger.error(EnumIsErrorMsg.TokenLoseEfficacy.getInfo(), token);
                return -1;
            } else {
                logger.info("成功获取userId", token);
                return userId;
            }
        } catch (Exception ex) {
            //运行时异常
            logger.error(EnumIsErrorMsg.GetUserIdError.getInfo(), token);
            return -2;
        }
    }

    /**
     * @param userId
     * @param token
     * @param appId
     * @param deviceId
     * @param deviceName
     * @Description: 用户登录成功后为该用户分配一个Token（uuid），并将Token和userId关联关系存储。
     * 放入redis缓存
     * @Param: userId 登录成功用户id
     * @Return: token 为该用户分配的token
     */
    @Override
    public int putUserIdAndToken(int userId, String token, String appId, String deviceId, String deviceName) throws Exception {
        return 0;
    }

    /**
     * 修改用户密码
     *
     * @param changePasswordArgs
     */
    @Override
    public boolean changePassword(ChangePasswordArgs changePasswordArgs) throws Exception {
        return false;
    }

    /**
     * 通过手机验证码快速登录或认证接口通用部分
     *
     * @param validatePhone
     */
    @Override
    public Integer fastLoginOrValidate(ValidatePhone validatePhone) throws Exception {
        return null;
    }

    /**
     * 重置用户密码
     *
     * @param agentId
     * @param resetPasswordArgs
     */
    @Override
    public boolean resetPassword(Integer agentId, ResetPasswordArgs resetPasswordArgs) throws Exception {
        return false;
    }

    /**
     * 用户绑定手机号
     *
     * @param agentId
     * @param bindPhoneArgs
     * @return
     * @throws Exception
     */
    @Override
    public boolean bindPhone(Integer agentId, BindPhoneArgs bindPhoneArgs) throws Exception {
        return false;
    }

    /**
     * 判断手机号是否被绑定
     *
     * @param phone
     * @return
     * @throws Exception
     */
    @Override
    public boolean ifPhoneBind(String phone) throws Exception {
        return false;
    }

    /**
     * 管理台修改密码
     *
     * @param userId
     * @param newPassword
     * @return
     */
    @Override
    public boolean insiApChangePassword(Integer userId, String newPassword) {
        return false;
    }
}