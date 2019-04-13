package com.pgleon.user.service;


import com.pgleon.mallspringboot.user.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserApiException extends UserException {

    private static final Logger logger = LoggerFactory.getLogger(UserApiException.class);

    public UserApiException(String message) {
        super(message);
    }

    public UserApiException(Exception e) {
        super(e);
    }

    public static class LoginException extends UserApiException {

        public LoginException(String message) {
            super(message);
        }
    }

    public static class LoginNameException extends UserApiException {

        public LoginNameException(String message) {
            super(message);
        }
    }

    public static class LoginPasswordException extends UserApiException {

        public LoginPasswordException(String message) {
            super(message);
        }
    }

    public static class LoginUnclearException extends UserApiException {

        public LoginUnclearException(String message) {
            super(message);
        }
    }

    public static class thirdLoginError extends UserApiException {

        public thirdLoginError(String message) {
            super(message);
        }
    }

    public static class thirdNoLoginException extends UserApiException {

        public thirdNoLoginException(String message) {
            super(message);
        }
    }

    public static class thirdLoginPasswordException extends UserApiException {

        public thirdLoginPasswordException(String message) {
            super(message);
        }
    }

    public static class thirdLoginException extends UserApiException {

        public thirdLoginException(String message) {
            super(message);
        }
    }

    public static class tokenLoseEfficacyException extends UserApiException {

        public tokenLoseEfficacyException(String message) {
            super(message);
        }
    }

    public static class deleteTokenException extends UserApiException {

        public deleteTokenException(String message) {
            super(message);
        }
    }

    public static class saveTokenException extends UserApiException {

        public saveTokenException(String message) {
            super(message);
        }
    }

    public static class noEnoughArgsException extends UserApiException {

        public noEnoughArgsException(String message) {
            super(message);
        }
    }

    /**
     * insiAP登录接口异常，用户名或密码错误
     */
    public static class insiApLoginException extends UserApiException {

        public insiApLoginException(String message) {
            super(message);
        }
    }

    /**
     * insiAP接口，账户已存在
     */
    public static class accountAlreadyExistException extends UserApiException {

        public accountAlreadyExistException(String message) {
            super(message);
        }
    }

    /**
     * 手机验证码异常
     */
    public static class sendValidateCodeException extends UserApiException {

        public sendValidateCodeException(String message) {
            super(message);
        }
    }

    /**
     * 服务器端出现异常
     */
    public static class InternalServerException extends UserApiException {

        public InternalServerException(String message) {
            super(message);
        }
    }

    /**
     * 修改密码时更新密码失败
     */
    public static class updatePasswordException extends UserApiException {

        public updatePasswordException(String message) {
            super(message);
        }
    }

    /**
     * 手机验证码验证失败
     */
    public static class PhoneValidateCodeException extends UserApiException {

        public PhoneValidateCodeException(String message) {
            super(message);
        }
    }

    /**
     * 手机号码已经被占用
     */
    public static class PhoneAlreadyUsedException extends UserApiException {

        public PhoneAlreadyUsedException(String message) {
            super(message);
        }
    }

    /**
     * 通用错误提示
     */
    public static class AvaliableCatchException extends UserApiException {

        public AvaliableCatchException(String message) {
            super(message);
        }
    }

    /**
     * 未找到公司
     */
    public static class CompanyNotFoundException extends UserApiException {

        public CompanyNotFoundException(String message) {
            super(message);
        }
    }
}
