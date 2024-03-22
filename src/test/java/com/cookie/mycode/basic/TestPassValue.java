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
        Integer integer = 500;
        String string = "前string";
        Ref ref = new Ref("李四", 20, 1);
        System.out.println(i);
        System.out.println(integer);
        System.out.println(string);
        System.out.println(ref);
        System.out.println(System.identityHashCode(integer));
        System.out.println(System.identityHashCode(string));
        System.out.println(System.identityHashCode(ref));
        System.out.println("===============================================");
        passInt(i);
        passInteger(integer);
        passString(string);
        passReference(ref);
        System.out.println(i);
        System.out.println(integer);
        System.out.println(string);
        System.out.println(ref);
        System.out.println(System.identityHashCode(integer));
        System.out.println(System.identityHashCode(string));
        System.out.println(System.identityHashCode(ref));
        Integer is = 500;
        System.out.println(System.identityHashCode(is));
        /*System.out.println("===============================================");
        int intRtn = passIntRtn(i);
        Integer integerRtn = passIntegerRtn(integer);
        String stringRtn = passStringRtn(string);
        System.out.println(i);
        System.out.println(integer);
        System.out.println(string);*/
    }

    private void passInt(int num){
        num = 100;
    }
    private int passIntRtn(int num){
        num = 100;
        return num;
    }

    private void passInteger(Integer count){
        System.out.println(System.identityHashCode(count) + "ssss");
        count = 500;
        System.out.println(System.identityHashCode(count) + "ssss");
    }
    private Integer passIntegerRtn(Integer count){
        count = 500;
        return count;
    }

    private void passString(String s){
        s = "后string";
    }
    private String  passStringRtn(String s){
        s = "后string";
        return s;
    }

    private void passReference(Ref ref){
        ref.setName("王五");
        ref.setAge(60);
        ref.setNum(3);
    }

    private Ref passReferenceRtn(Ref ref){
        ref.setName("王五");
        ref.setAge(60);
        ref.setNum(3);
        return ref;
    }
}

@Data
//@ToString
@AllArgsConstructor
@NoArgsConstructor
class Ref{
    String name;
    int age;
    Integer num;
}
