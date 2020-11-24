package com.frame.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
//在微服务启动的时候加载我们自定义的Ribbon类
@EnableFeignClients
@EnableCircuitBreaker //添加对熔断的支持
public class ConsumerUAC {
    public static void main(String[] args){
        SpringApplication.run(ConsumerUAC.class,args);
    }
}
