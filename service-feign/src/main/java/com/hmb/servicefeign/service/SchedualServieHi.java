package com.hmb.servicefeign.service;

import com.hmb.servicefeign.service.serviceImpl.SchedualServiceHiHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hmb
 * @date 2019/5/8 13:05
 * 定义一个feign接口，通过@ FeignClient（“服务名”），来指定调用哪个服务。比如在代码中调用了service-hi服务的“/hi”接口
 *
 * 使用断路器：
 * 基于service-feign工程进行改造，只需要在FeignClient的SchedualServiceHi接口的注解中加上fallback的指定类就行了
 */
@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
public interface SchedualServieHi {
    @RequestMapping(value = "/hi/{name}",method = RequestMethod.GET)
    String sayHiFromClientOne(@PathVariable(value = "name")String name);
}
