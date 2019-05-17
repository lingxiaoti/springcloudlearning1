package com.hmb.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


/**
 * @author hmb
 * @date 2019/5/16 13:15
 */
@SpringBootApplication
public class ConfigClientApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ConfigClientApplication.class,args);
        System.out.println("spring容器: " + applicationContext
        );
    }
}
