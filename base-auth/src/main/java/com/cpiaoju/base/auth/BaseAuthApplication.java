package com.cpiaoju.base.auth;

import com.cpiaoju.base.common.annotation.BaseCloudApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@BaseCloudApplication
@MapperScan("com.cpiaoju.base.auth.mapper")
public class BaseAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseAuthApplication.class, args);
	}

}
