package com.frame.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //在启动后自动注册到eureka中
@EnableDiscoveryClient  //服务发现
public class providerUAC {
    public static void main(String[] args){
        SpringApplication.run(providerUAC.class,args);
    }
}
