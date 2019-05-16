package com.hmb.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author hmb
 * @date 2019/5/7 21:36
 * description: 通过@EnableDiscoveryClient注解向服务注册中心;
 * 并且向程序的ioc注入一个bean:restTemplate;并通过@LoadBalanced注解表明
 * 这个restTemplate开启了负载均衡的功能
 *
 * @EnableHystrix 加入这个注解开启Hystrix功能
 * 在主程序启动类中加入@EnableHystrixDashboard注解，开启hystrixDashboard：
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class ServiceRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class,args);
    }

    @Bean
    @LoadBalanced //这表示负载均衡功能
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
