package com.cpiaoju.base.server.test;

import com.cpiaoju.base.common.annotation.BaseCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author ziyou
 */
@EnableFeignClients
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@BaseCloudApplication
public class BaseServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseServerTestApplication.class, args);
    }

}
