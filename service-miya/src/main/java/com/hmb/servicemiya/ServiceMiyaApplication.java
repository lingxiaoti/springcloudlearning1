package com.hmb.servicemiya;

import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author hmb
 * @date 2019/6/15 20:47
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceMiyaApplication {
    public static final Logger logger = LoggerFactory.getLogger(ServiceMiyaApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(ServiceMiyaApplication.class,args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @RequestMapping("/hi")
    public String home(){
        logger.info("hi is being called");
        return "hi i'm miya";
    }

    @RequestMapping("/miya")
    public String info(){
        return restTemplate.getForObject("http://localhost:8762/info",String.class);
    }
}
