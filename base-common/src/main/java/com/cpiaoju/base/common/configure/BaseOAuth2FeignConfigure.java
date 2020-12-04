package com.cpiaoju.base.common.configure;

import com.cpiaoju.base.common.constant.BaseConstant;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.util.Base64Utils;

/**
 * <p>开启带令牌的Feign请求，避免微服务内部调用出现401异常</p>
 *
 * @author ziyou
 */
public class BaseOAuth2FeignConfigure {

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return requestTemplate -> {
            // 添加 gateWay Token
            String gatewayToken = new String(Base64Utils.encode(BaseConstant.GATEWAY_TOKEN_VALUE.getBytes()));
            requestTemplate.header(BaseConstant.GATEWAY_TOKEN_HEADER, gatewayToken);

            Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
            if (details instanceof OAuth2AuthenticationDetails) {
                String authorizationToken = ((OAuth2AuthenticationDetails) details).getTokenValue();
                requestTemplate.header(HttpHeaders.AUTHORIZATION, "bearer " + authorizationToken);
            }
        };
    }
}
