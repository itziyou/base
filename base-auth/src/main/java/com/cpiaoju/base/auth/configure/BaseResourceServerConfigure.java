package com.cpiaoju.base.auth.configure;

import com.cpiaoju.base.auth.properties.BaseAuthProperties;
import com.cpiaoju.base.common.handler.BaseAccessDeniedHandler;
import com.cpiaoju.base.common.handler.BaseAuthExceptionEntryPoint;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author ziyou
 * <p>@EnableResourceServer order=3</p>
 * <p>用于处理非 /oauth/ 开头的请求，其主要用于资源的保护，客户端只能通过OAuth2协议发放的令牌来从资源服务器中获取受保护的资源。</p>
 */
@Configuration
@EnableResourceServer
public class BaseResourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Autowired
    private BaseAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private BaseAuthExceptionEntryPoint exceptionEntryPoint;
    @Autowired
    private BaseAuthProperties properties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnonUrl(), ",");

        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers(anonUrls).permitAll()
                .antMatchers("/**").authenticated()
                .and().httpBasic();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
