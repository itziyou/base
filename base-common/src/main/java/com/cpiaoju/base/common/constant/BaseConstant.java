package com.cpiaoju.base.common.constant;

/**
 * @author ziyou
 */
public interface BaseConstant {
    /**
     * Gateway请求头TOKEN名称（不要有空格）
     */
    String GATEWAY_TOKEN_HEADER = "GatewayToken";
    /**
     * Gateway请求头TOKEN值
     */
    String GATEWAY_TOKEN_VALUE = "admin:gateway:123456";

    /**
     * gif类型
     */
    public static final String GIF = "gif";
    /**
     * png类型
     */
    public static final String PNG = "png";

    /**
     * 验证码 key前缀
     */
    public static final String CODE_PREFIX = "base.captcha.";
}
