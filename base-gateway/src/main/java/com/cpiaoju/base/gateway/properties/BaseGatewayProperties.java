package com.cpiaoju.base.gateway.properties;


import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author ziyou
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:base-gateway.properties"})
@ConfigurationProperties(prefix = "base.gateway")
public class BaseGatewayProperties {
    /**
     * 禁止外部访问的 URI，多个值的话以逗号分隔
     */
    private String forbidRequestUri;
}
