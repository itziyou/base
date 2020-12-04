package com.cpiaoju.base.server.system.configure;

import com.cpiaoju.base.common.handler.BaseAccessDeniedHandler;
import com.cpiaoju.base.common.handler.BaseAuthExceptionEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author ziyou
 */
@Configuration
@EnableResourceServer
@RequiredArgsConstructor
public class BaseServerSystemResourceServerConfigure extends ResourceServerConfigurerAdapter {

    private final BaseAccessDeniedHandler accessDeniedHandler;
    private final BaseAuthExceptionEntryPoint exceptionEntryPoint;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers("/**").authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
