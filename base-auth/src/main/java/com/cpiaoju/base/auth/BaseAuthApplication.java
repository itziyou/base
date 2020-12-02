package com.cpiaoju.base.auth;

import com.cpiaoju.base.common.annotation.EnableBaseAuthExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableBaseAuthExceptionHandler
public class BaseAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseAuthApplication.class, args);
	}

}
