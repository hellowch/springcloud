package com.frame.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    //为了让消费者的controller可以获得到服务提供者的server
    @Bean
    @LoadBalanced  //配置负载均衡实现 Ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

