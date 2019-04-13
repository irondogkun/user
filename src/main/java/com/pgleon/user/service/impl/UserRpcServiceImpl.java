package com.pgleon.user.service.impl;/**
 * Created by leon on 2019-04-13 15:12
 */

import com.pgleon.rpcapi.user.UserService;
import com.pgleon.rpcapi.user.pojo.TokenIdentity;
import com.pgleon.rpcapi.user.pojo.UserType;
import com.pgleon.rpcapi.user.pojo.ValidatePhone;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: leon
 * @Date: 2019-04-13 15:12
 * @Description:
 */
@Service
public class UserRpcServiceImpl implements UserService {
    /**
     * @param token
     * @Description: 根据token获取用户id
     * @Param: token
     * @Return: userId 正常userId > 0,
     * 若token失效则返回 -1，
     * 若在获取userId过程中出现异常则返回 -2。
     */
    @Override
    public int getUserIdByToken(String token) {
        return 0;
    }

    /**
     * 提供短信验证码正确性验证的rpc接口
     *
     * @param validatePhone
     */
    @Override
    public boolean validatePhoneCheck(ValidatePhone validatePhone) throws Exception {
        return false;
    }

    /**
     * 保存登录信息，生成token
     *
     * @param accountId
     * @return
     */
    @Override
    public String createToken(Integer accountId) {
        return null;
    }

    /**
     * 根据公司Id和代理人获取开通模块
     *
     * @param companyId
     * @param agentId
     * @return
     */
    @Override
    public List<Integer> getOpenedModules(Integer companyId, Integer agentId) {
        return null;
    }

    /**
     * 根据token获取账户类型
     *
     * @param token
     * @return
     */
    @Override
    public UserType getUserTypeByToken(String token) {
        return null;
    }

    /**
     * 根据token获取token体
     *
     * @param token
     * @return
     */
    @Override
    public TokenIdentity getTokenIdentityByToken(String token) {
        return null;
    }

    /**
     * 获取当前代理人最新的token
     *
     * @param userId
     * @param appId
     * @return
     */
    @Override
    public TokenIdentity getLastTokenIdentity(Integer userId, String appId) {
        return null;
    }

    /**
     * 删除失效token 修改密码删除和异地登录删除
     *
     * @param token
     * @return
     */
    @Override
    public boolean deleteInvalidateToken(String token) {
        return false;
    }
}
