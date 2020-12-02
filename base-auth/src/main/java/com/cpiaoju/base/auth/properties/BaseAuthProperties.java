package com.cpiaoju.base.auth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author ziyou
 * <p>PropertySource 用于指定读取的配置文件路径</p>
 * <p>ConfigurationProperties 指定了要读取的属性的统一前缀名称为</p>
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:base-auth.properties"})
@ConfigurationProperties(prefix = "base.auth")
public class BaseAuthProperties {

    private BaseClientsProperties[] clients = {};
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;

    /**
     * 免认证路径
     */
    private String anonUrl;

    /**
     * 验证码配置类
     */
    private BaseValidateCodeProperties code = new BaseValidateCodeProperties();

}
