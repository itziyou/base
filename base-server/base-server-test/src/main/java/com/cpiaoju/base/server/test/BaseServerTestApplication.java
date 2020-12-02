package com.cpiaoju.base.server.test;

import com.cpiaoju.base.common.annotation.EnableBaseAuthExceptionHandler;
import com.cpiaoju.base.common.annotation.EnableBaseOauth2FeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableBaseAuthExceptionHandler
@EnableBaseOauth2FeignClient
public class BaseServerTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseServerTestApplication.class, args);
	}

}
