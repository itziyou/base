package com.cpiaoju.base.auth.configure;

import com.cpiaoju.base.auth.filter.ValidateCodeFilter;
import com.cpiaoju.base.auth.service.BaseUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author ziyou
 * <p>用于处理/oauth开头的请求</p>
 * <p>Spring Cloud OAuth 内部定义的获取令牌，刷新令牌的请求地址都是以 /oauth/ 开头的</p>
 * <p>也就是说 CloudSecurityConfigure 用于处理和令牌相关的请求</p>
 */
@Order(2)
@EnableWebSecurity
public class BaseSecurityConfigure extends WebSecurityConfigurerAdapter {

    @Autowired
    private BaseUserDetailService userDetailService;

    /**
     * BCryptPasswordEncoder 的特点就是，对于一个相同的密码，每次加密出来的加密串都不同：
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ValidateCodeFilter validateCodeFilter;


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .requestMatchers()
                .antMatchers("/oauth/**")
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").authenticated()
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
    }
}
