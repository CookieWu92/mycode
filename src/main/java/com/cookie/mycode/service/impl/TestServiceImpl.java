package com.cookie.mycode.service.impl;

import com.cookie.mycode.service.TestService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @Desc:
 * @Author: CookieWu
 * @Date: 2024/2/27 13:38
 * @Version: v1.0
 */
@Service
public class TestServiceImpl implements TestService {
    public Integer integer = 0;
    @Override
    public Integer negate(Integer src){
        integer++;
        return src*-1 + integer;
    }
}
