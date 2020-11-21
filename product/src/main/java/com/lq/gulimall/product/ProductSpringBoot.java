package com.lq.gulimall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
/**
 *
 *
 *    数据校验 JSR303
 *    1.给bean 添加教养注解
 */
public class ProductSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(ProductSpringBoot.class,args);
    }
}
