package com.cpiaoju.base.auth;

import com.cpiaoju.base.common.annotation.BaseCloudApplication;
import com.cpiaoju.base.common.annotation.EnableBaseLettuceRedis;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ziyou
 */
@SpringBootApplication
@BaseCloudApplication
@EnableBaseLettuceRedis
@MapperScan("com.cpiaoju.base.auth.mapper")
public class BaseAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseAuthApplication.class, args);
    }

}
