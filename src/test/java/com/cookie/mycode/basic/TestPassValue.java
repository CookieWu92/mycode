package com.cookie.mycode.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @Desc: 传值测试
 * @Author: CookieWu
 * @Date: 2024/1/22 14:41
 * @Version: v1.0
 */
@Slf4j
public class TestPassValue {
    @Test
    public void test(){
        int i = 1;
        Integer integer = 2;
        String string = "变身前";
        Ref ref = new Ref("李四", 20, 1);
        System.out.println(i);
        System.out.println(integer);
        System.out.println(string);
        System.out.println(ref);
        System.out.println("===============================================");
        passInt(i);
        pasInteger(integer);
        passString(string);
        passReference(ref);
        System.out.println(i);
        System.out.println(integer);
        System.out.println(string);
        System.out.println(ref);
    }

    private void passInt(int num){
        num = 100;
    }

    private void pasInteger(Integer count){
        count = 200;
    }

    private void passString(String s){
        s = "变身后";
    }

    private void passReference(Ref ref){
        ref.setName("王五");
        ref.setAge(60);
        ref.setNum(3);
    }
}

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
class Ref{
    String name;
    int age;
    Integer num;
}
