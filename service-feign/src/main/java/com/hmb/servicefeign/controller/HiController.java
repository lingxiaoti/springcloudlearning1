package com.hmb.servicefeign.controller;

import com.hmb.servicefeign.service.SchedualServieHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hmb
 * @date 2019/5/8 13:12
 * description:对外暴露一个"/hi" 的API接口
 */
@RestController
public class HiController {
    @Autowired
    private SchedualServieHi schedualServieHi;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHiFromClientOne(@RequestParam("name") String name){
        return schedualServieHi.sayHiFromClientOne(name);
    }
}
