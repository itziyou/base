package com.cpiaoju.base.common.configure;

import com.cpiaoju.base.common.interceptor.BaseServerProtectInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ziyou
 */
public class BaseServerProtectConfigure implements WebMvcConfigurer {

    /**
     * <p> @ConditionalOnMissingBean 注解的意思是，当IOC容器中没有指定名称或类型的Bean的时候，就注册它</p>
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(value = PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HandlerInterceptor baseServerProtectInterceptor() {
        return new BaseServerProtectInterceptor();
    }

    @Override
    @SuppressWarnings("all")
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseServerProtectInterceptor());
    }
}
