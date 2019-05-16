package com.hmb.servicefeign.service.serviceImpl;

import com.hmb.servicefeign.service.SchedualServieHi;
import org.springframework.stereotype.Component;

/**
 * @author hmb
 * @date 2019/5/9 21:39
 * description:SchedualServiceHiHystric需要实现SchedualServiceHi 接口，并注入到Ioc容器中
 */
@Component
public class SchedualServiceHiHystric implements SchedualServieHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
