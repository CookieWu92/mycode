package com.cookie.mycode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Desc:
 * @Author: CookieWu
 * @Date: 2023/10/16 15:12
 * @Version: v1.0
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private String gender;
    private boolean alive;
}
