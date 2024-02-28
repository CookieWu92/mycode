package com.cookie.mycode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.cookie.*")
public class MycodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycodeApplication.class, args);
    }

}
