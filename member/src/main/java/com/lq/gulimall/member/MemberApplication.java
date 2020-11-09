package com.lq.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 *  想要远程调用服务
 *  1.引用open-fegin
 *  2.编写一个接口,告诉srpingCloud 这个接口需要调用远程服务
 * 	3.声明接口的每一个方法都是调用那个远程服务的请求
 * 开启远程调用功能
 *
 * */
@EnableFeignClients(basePackages = "com.lq.gulimall.member.fegin")//扫描要远程调用的包
@SpringBootApplication
@EnableDiscoveryClient  //开启支持发现
public class MemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}

}
