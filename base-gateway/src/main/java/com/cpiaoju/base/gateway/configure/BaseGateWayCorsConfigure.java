package com.cpiaoju.base.gateway.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

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
    public CorsWebFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowCredentials(true);
        cors.addAllowedOrigin(CorsConfiguration.ALL);
        cors.addAllowedHeader(CorsConfiguration.ALL);
        cors.addAllowedMethod(CorsConfiguration.ALL);
        source.registerCorsConfiguration("/**", cors);
        return new CorsWebFilter(source);
    }


}
