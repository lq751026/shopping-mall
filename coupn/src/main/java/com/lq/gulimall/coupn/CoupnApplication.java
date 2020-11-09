package com.lq.gulimall.coupn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient  //开启注册支持
public class CoupnApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoupnApplication.class, args);
	}

}
