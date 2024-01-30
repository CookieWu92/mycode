package com.cookie.mycode.basic;

import java.math.BigDecimal;

/**
 *@Desc:
 *@Author: CookieWu
 *@Date: 2024/1/22 20:06
 *@Version: v1.0
*/
public class Test {
    @org.junit.jupiter.api.Test
    public void test(){
        String string = "10.00";
        System.out.println(new BigDecimal(string));
    }

    public void test2(){
        String string =
                "1234567.00" +
                "       10.5" +
                "      20.00" +
                "        5.0" +
                "      50.00" +
                "        1.0";
    
    }

}
