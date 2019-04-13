package com.pgleon.user.web;

import com.pgleon.mallspringboot.APIExceptionHandler;
import com.pgleon.mallspringboot.ErrorApiResponse;
import com.pgleon.mallspringboot.utils.SpringMvcUtils;
import com.pgleon.user.service.UserApiException;
import com.pgleon.user.service.UserErrorApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by leon on 2019-04-11 11:50
 */
@RestControllerAdvice("com.pgleon.user.web.api")
public class MyAPIExceptionHandler extends APIExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(MyAPIExceptionHandler.class);
    /**
     * @Description:用户登录异常
     */
    @ExceptionHandler(value = UserApiException.LoginException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> LoginExceptionHandler(HttpServletRequest request,
                                                                  Exception e) {
        logger.info("LoginExceptionHandler: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.loginErrorRequest(message.toString()));
    }

    /**
     * @Description:用户名不存在
     */
    @ExceptionHandler(value = UserApiException.LoginNameException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> LoginNameException(HttpServletRequest request,
                                                               Exception e) {
        logger.info("LoginNameException: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.loginNameRequest(message.toString()));
    }

    /**
     * @Description:用户登录密码不正确
     */
    @ExceptionHandler(value = UserApiException.LoginPasswordException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> LoginPasswordException(HttpServletRequest request,
                                                                   Exception e) {
        logger.info("LoginPasswordException: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.loginPasswordRequest(message.toString()));
    }

    /**
     * @Description:用户登录未指明的异常
     */
    @ExceptionHandler(value = UserApiException.LoginUnclearException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> LoginUnclearException(HttpServletRequest request,
                                                                  Exception e) {
        logger.error("LoginUnclearException: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.loginUnclearRequest(message.toString()));
    }

    /**
     * @Description:第三方登录异常
     */
    @ExceptionHandler(value = UserApiException.thirdLoginError.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> thirdLoginError(HttpServletRequest request,
                                                            Exception e) {
        logger.error("thirdLoginError: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.thirdLoginErrorRequest(message.toString()));
    }

    /**
     * @Description:第三方登录异常
     */
    @ExceptionHandler(value = UserApiException.thirdLoginException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> thirdLoginException(HttpServletRequest request,
                                                                Exception e) {
        logger.info("thirdLoginException: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.thirdLoginExceptionRequest(message.toString()));
    }

    /**
     * @Description:第三方登录密码错误异常
     */
    @ExceptionHandler(value = UserApiException.thirdLoginPasswordException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> thirdLoginPasswordException(HttpServletRequest request,
                                                                        Exception e) {
        logger.info("thirdLoginPasswordException: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.thirdLoginPasswordErrorRequest(message.toString()));
    }

    /**
     * @Description:第三方登录异常
     */
    @ExceptionHandler(value = UserApiException.thirdNoLoginException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> thirdNoLoginException(HttpServletRequest request,
                                                                  Exception e) {
        logger.info("thirdNoLoginException: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.thirdNoLoginRequest(message.toString()));
    }

    /**
     * @Description:没有足够的参数
     */
    @ExceptionHandler(value = UserApiException.noEnoughArgsException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> noEnoughArgsException(HttpServletRequest request,
                                                                  Exception e) {
        logger.info("noEnoughArgsException: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.noEnoughArgsRequest(message.toString()));
    }

    /**
     * insiAp登录接口，用户名或密码错误
     */
    @ExceptionHandler(value = UserApiException.insiApLoginException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> insiApLoginException(HttpServletRequest request,
                                                                 Exception e) {
        logger.info("insiApLoginException: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.insiApLoginException(message.toString()));
    }

    /**
     * insiAp新增账户接口，账户已存在
     */
    @ExceptionHandler(value = UserApiException.accountAlreadyExistException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> accountAlreadyExist(HttpServletRequest request,
                                                                Exception e) {
        logger.info("accountAlreadyExist: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.accountAlreadyExistException(message.toString()));
    }

    /**
     * 手机验证码异常
     */
    @ExceptionHandler(value = UserApiException.sendValidateCodeException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> sendValidateCodeException(HttpServletRequest request,
                                                                      Exception e) {
        logger.info("sendValidateCodeException: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.sendValidateCodeException(message.toString()));
    }

    /**
     * @Description:服务器端异常
     */
    @ExceptionHandler(value = UserApiException.InternalServerException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> internalServerException(HttpServletRequest request,
                                                                    Exception e) {
        logger.error("agentCreateException: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.internalServerException(message.toString()));
    }

    /**
     * @Description:修改密码时更新密码时失败
     */
    @ExceptionHandler(value = UserApiException.updatePasswordException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> updatePasswordException(HttpServletRequest request,
                                                                    Exception e) {
        logger.error("agentCreateException: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.updatePasswordException(message.toString()));
    }

    /**
     * @Description:快速登录失败
     */
    @ExceptionHandler(value = UserApiException.PhoneValidateCodeException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> phoneValidateCodeChenkException(HttpServletRequest request,
                                                                            Exception e) {
        logger.error("phoneValidateCodeChenkException: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.phoneValidateCodeCheckException(message.toString()));
    }

    /**
     * @Description:手机号码已经被占用
     */
    @ExceptionHandler(value = UserApiException.PhoneAlreadyUsedException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> phoneAlreadyUsedException(HttpServletRequest request,
                                                                      Exception e) {
        logger.error("phoneAlreadyUsedException: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.phoneAlreadyUsedException(message.toString()));
    }

    /**
     * @Description:通用错误提示
     */
    @ExceptionHandler(value = UserApiException.AvaliableCatchException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> avaliableCatchException(HttpServletRequest request,
                                                                    Exception e) {
        logger.error("avaliableCatchException: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.avaliableCatchException(message.toString()));
    }

    /**
     * @Description:未找到相应公司
     */
    @ExceptionHandler(value = UserApiException.CompanyNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorApiResponse> companyNotFoundException(HttpServletRequest request,
                                                                     Exception e) {
        logger.error("companyNotFoundException: {} ", request, e);
        StringBuilder message = new StringBuilder()
                .append(e.getMessage());
        if (SpringMvcUtils.getTraceParameter(request)) {
            message.append("\n\r");
            message.append(stackTrace(e));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserErrorApiResponse.companyNotFoundException(message.toString()));
    }
}
