package com.cpiaoju.base.common.exception;

/**
 * <p>验证码相关异常</p>
 *
 * @author ziyou
 */
public class ValidateCodeException extends Exception {
    private static final long serialVersionUID = -8955767290619122172L;

    public ValidateCodeException(String message) {
        super(message);
    }
}
