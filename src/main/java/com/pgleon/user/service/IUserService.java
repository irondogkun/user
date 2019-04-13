package com.pgleon.user.service;

import com.pgleon.rpcapi.user.pojo.ValidatePhone;
import com.pgleon.user.domain.pojo.BindPhoneArgs;
import com.pgleon.user.domain.pojo.ChangePasswordArgs;
import com.pgleon.user.domain.pojo.LoginResult;
import com.pgleon.user.domain.pojo.ResetPasswordArgs;

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
     * @Description: 登录接口
     * @Param:
     * @Return:
     */
    LoginResult login(LoginArgs loginArgs, HttpServletRequest request) throws Exception;


    /**
     * @Description: 退出登录接口
     * @Param:
     * @Return:
     */
    Object logout(String token, int userId) throws Exception;

    /**
     * @Description: 根据token获取userId
     * @Param:
     * @Return:
     */
    Integer getUserIdByToken(String token);


    /**
     * @Description: 用户登录成功后为该用户分配一个Token（uuid），并将Token和userId关联关系存储。
     * 放入redis缓存
     * @Param: userId 登录成功用户id
     * @Return: token 为该用户分配的token
     */
    int putUserIdAndToken(int userId, String token, String appId, String deviceId, String deviceName) throws Exception;



    /**
     * 修改用户密码
     */
    boolean changePassword(ChangePasswordArgs changePasswordArgs) throws Exception;

    /**
     * 通过手机验证码快速登录或认证接口通用部分
     */
    Integer fastLoginOrValidate(ValidatePhone validatePhone) throws Exception;


    /**
     * 重置用户密码
     */
    boolean resetPassword(Integer agentId, ResetPasswordArgs resetPasswordArgs) throws Exception;

    /**
     * 用户绑定手机号
     * @param agentId
     * @param bindPhoneArgs
     * @return
     * @throws Exception
     */
    boolean bindPhone(Integer agentId, BindPhoneArgs bindPhoneArgs) throws Exception;

    /**
     * 判断手机号是否被绑定
     * @param phone
     * @return
     * @throws Exception
     */
    boolean ifPhoneBind(String phone) throws Exception;


    /**
     * 管理台修改密码
     * @param userId
     * @param newPassword
     * @return
     */
    boolean insiApChangePassword(Integer userId, String newPassword);

}