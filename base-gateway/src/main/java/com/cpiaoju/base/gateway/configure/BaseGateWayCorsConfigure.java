package com.cpiaoju.base.gateway.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author ziyou
 */
@Configuration
public class BaseGateWayCorsConfigure {

    /**
     * <p>setAllowCredentials(true)表示允许cookie跨域；</p>
     * <p>addAllowedHeader(CorsConfiguration.ALL)表示请求头部允许携带任何内容；</p>
     * <p>addAllowedOrigin(CorsConfiguration.ALL)表示允许任何来源；</p>
     * <p>addAllowedMethod(CorsConfiguration.ALL)表示允许任何HTTP方法。</p>
     *
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        corsConfiguration.addAllowedOrigin(CorsConfiguration.ALL);
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }

}
