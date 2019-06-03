package com.hmb.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hmb
 * @date 2019/6/3 23:03
 */
@RestController
public class HelloController {
    @Value("${neo.hello}")
    String hello;

    @RequestMapping("/hello")
    public String hi(){
        return this.hello;
    }
}
