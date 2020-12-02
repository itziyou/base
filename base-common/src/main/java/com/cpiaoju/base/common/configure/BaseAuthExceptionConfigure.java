package com.cpiaoju.base.common.configure;

import com.cpiaoju.base.common.handler.BaseAccessDeniedHandler;
import com.cpiaoju.base.common.handler.BaseAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author ziyou
 */
public class BaseAuthExceptionConfigure {
    /**
     * <p>@ConditionalOnMissingBean 注解的意思是，当IOC容器中没有指定名称或类型的Bean的时候，就注册它。</p>
     * <p>这样做的好处在于，子系统可以自定义自个儿的资源服务器异常处理器，覆盖我们在base-common通用模块里定义的</p>
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public BaseAccessDeniedHandler accessDeniedHandler() {
        return new BaseAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public BaseAuthExceptionEntryPoint authenticationEntryPoint() {
        return new BaseAuthExceptionEntryPoint();
    }
}
