package com.cpiaoju.base.server.system;

import com.cpiaoju.base.common.annotation.BaseCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@BaseCloudApplication
public class BaseServerSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseServerSystemApplication.class, args);
	}

}
