package com.hmb.eurakaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author hmb
 * @date 2019/6/3 23:25
 */
@SpringBootApplication
@EnableEurekaServer
public class EurakaService1Application {
    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(EurakaService1Application.class, args);
        System.out.println("spring容器： " + run);
    }
}
