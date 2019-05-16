package com.hmb.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author hmb
 * @date 2019/5/7 22:03
 */
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 这里是RestTemplate + Ribbon去消费服务
     * 这里是没有加断路器的方法
     * @param name
     * @return
     */
    /*public String hiService(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi/"+name,String.class);
    }*/

    /**
     * 在这个方法上面加上@HystrixCommand注解,该注解对该方法创建了熔断器的功能
     * 并指定了fallbackMethod熔断方法
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi/"+name,String.class);
    }

    public String hiError(String name){
        return "hello," + name + ",sorry,error!";
    }
}
