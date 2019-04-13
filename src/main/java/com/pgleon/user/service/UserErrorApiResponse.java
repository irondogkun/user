package com.pgleon.user.service;


import com.pgleon.mallspringboot.ErrorApiResponse;

public final class UserErrorApiResponse {
    public static ErrorApiResponse loginErrorRequest(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100001")
                .withType("Wrong UserName or Password")
                .withMessage(message)
                .build();
    }

    public static ErrorApiResponse loginNameRequest(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100002")
                .withType("No UserName")
                .withMessage(message)
                .build();
    }

    public static ErrorApiResponse loginPasswordRequest(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100003")
                .withType("Wrong Password")
                .withMessage(message)
                .build();
    }

    public static ErrorApiResponse loginUnclearRequest(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100004")
                .withType("Login Unclear Error")
                .withMessage(message)
                .build();
    }

    public static ErrorApiResponse thirdLoginErrorRequest(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100005")
                .withType("ThirdPathLogin Error")
                .withMessage(message)
                .build();
    }

    public static ErrorApiResponse thirdNoLoginRequest(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100006")
                .withType("ThirdPathLogin Error")
                .withMessage(message)
                .build();
    }

    public static ErrorApiResponse thirdLoginPasswordErrorRequest(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100007")
                .withType("Wrong Password")
                .withMessage(message)
                .build();
    }

    public static ErrorApiResponse thirdLoginExceptionRequest(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100008")
                .withType("Some Exceptions")
                .withMessage(message)
                .build();
    }

    public static ErrorApiResponse deleteTokenErrorRequest(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100009")
                .withType("Delete Token Fail")
                .withMessage(message)
                .build();
    }

    public static ErrorApiResponse tokenLoseEfficacyRequest(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100010")
                .withType("Token Lose Efficacy")
                .withMessage(message)
                .build();
    }

    public static ErrorApiResponse noEnoughArgsRequest(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100011")
                .withType("No Enough Args")
                .withMessage(message)
                .build();
    }

    /**
     * 管理台登录异常，用户名或密码错误
     *
     * @parad
     */
    public static ErrorApiResponse insiApLoginException(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100012")
                .withType("Login Error , UserName Or Password Wrong")
                .withMessage(message)
                .build();
    }

    /**
     * 管理台新增账户接口，账户已存在
     */
    public static ErrorApiResponse accountAlreadyExistException(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100013")
                .withType("Account Already Exist")
                .withMessage(message)
                .build();
    }


    /**
     * 手机验证码异常
     */
    public static ErrorApiResponse sendValidateCodeException(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100014")
                .withType("Send Validate Code Exception")
                .withMessage(message)
                .build();
    }

    /**
     * 服务器端出现异常
     */
    public static ErrorApiResponse internalServerException(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("500")
                .withType("Internal Server Exception")
                .withMessage(message)
                .build();
    }

    /**
     * 修改密码时更新密码失败
     */
    public static ErrorApiResponse updatePasswordException(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100016")
                .withType("Update Password Exception")
                .withMessage(message)
                .build();
    }

    /**
     * 快速登录失败
     */
    public static ErrorApiResponse phoneValidateCodeCheckException(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100018")
                .withType("Phone ValidateCode Check Exception")
                .withMessage(message)
                .build();
    }

    /**
     * 手机号码已经被占用
     */
    public static ErrorApiResponse phoneAlreadyUsedException(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100019")
                .withType("Phone Already Used Exception")
                .withMessage(message)
                .build();
    }

    /**
     * 通用错误提示
     */
    public static ErrorApiResponse avaliableCatchException(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100020")
                .withType("Avaliable Catch Exception")
                .withMessage(message)
                .build();
    }

    /**
     * 未找到公司
     */
    public static ErrorApiResponse companyNotFoundException(String message) {

        return ErrorApiResponse.ErrorApiResponseBuilder.anErrorAPIResponse()
                .withCode("100021")
                .withType("Company Not Found")
                .withMessage(message)
                .build();
    }
}