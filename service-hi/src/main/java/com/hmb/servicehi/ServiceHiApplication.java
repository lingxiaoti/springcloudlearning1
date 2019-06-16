package com.hmb.servicehi;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * 通过注解@EnableEurekaClient 表明自己是一个eurekaclient.
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class ServiceHiApplication {
    Logger logger = LoggerFactory.getLogger(ServiceHiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi/{name}")
    public String  home(@PathVariable("name") String name){
        return  "hi "+"你好"+",i am from port:" +"端口号";
    }

    @RequestMapping("/info")
    public String info(){
        logger.info("调用info接口{}","INFO接口");
        return "I'm service-hi";
    }

    @RequestMapping("/hi")
    public String callHome(){
        logger.info("calling trace service-hi");
        return restTemplate.getForObject("http://localhost:9412/miya",String.class);
    }
}
