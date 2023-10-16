package com.cookie.mycode;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class LogTest {

    public static void main(String[] args) {
        try {
            int i = 1/0;
        } catch (Exception e) {
//            List<BigDecimal> asList = Arrays.asList(new BigDecimal("10.00"), new BigDecimal("29.50"), new BigDecimal("12.00"));
            List<String> asList = Arrays.asList("asd", "dfg", "hjk");
            String s = "ggg";
            log.error("券别{}不{}存在", asList, s, e);
        }
        System.out.println("ssssss");
    }

}
