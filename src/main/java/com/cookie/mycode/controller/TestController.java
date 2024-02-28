package com.cookie.mycode.controller;

import com.cookie.mycode.service.TestService;
import com.cookie.mycode.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Desc:
 * @Author: CookieWu
 * @Date: 2024/2/27 13:36
 * @Version: v1.0
 */
@Controller
public class TestController {
    @Autowired
    private TestService testService;
    private Integer init = 0;

    @RequestMapping("/app")
    @ResponseBody
    public String append(@RequestParam("a") String a, @RequestParam("b") String b){
        init++;
        Integer negate = testService.negate(9);
        return a+init+b+negate;
    }

}
