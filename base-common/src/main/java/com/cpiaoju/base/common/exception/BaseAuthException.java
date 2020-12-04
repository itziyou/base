package com.cpiaoju.base.common.exception;

/**
 * <p>认证相关异常</p>
 *
 * @author ziyou
 */
public class BaseAuthException extends Exception {

    private static final long serialVersionUID = -5582103938466980345L;

    public BaseAuthException(String message) {
        super(message);
    }
}
