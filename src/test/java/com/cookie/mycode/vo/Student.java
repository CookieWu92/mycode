package com.cookie.mycode.vo;

import lombok.*;

/**
 * @Desc:
 * @Author: CookieWu
 * @Date: 2024/1/31 14:52
 * @Version: v1.0
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String name;
    private int age;
    private String clazz;
    private String course;
    private int score;

}
