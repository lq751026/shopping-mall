package com.lq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ThridPartySpirng {
    public static void main(String[] args) {
        SpringApplication.run(ThridPartySpirng.class,args);
    }
}
