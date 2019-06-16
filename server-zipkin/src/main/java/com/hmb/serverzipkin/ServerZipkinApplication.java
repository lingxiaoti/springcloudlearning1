package com.hmb.serverzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * @author hmb
 * @date 2019/6/15 17:55
 * 加上注解@EnableZipkinServer，开启ZipkinServer的功能
 */
@SpringBootApplication
@EnableZipkinServer
public class ServerZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerZipkinApplication.class,args);
    }
}
