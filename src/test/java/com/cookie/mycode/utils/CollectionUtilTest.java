package com.cookie.mycode.utils;

import com.cookie.mycode.domain.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: CookieWu
 * @Date: 2023/10/16 15:17
 * @Version: v1.0
 */

public class CollectionUtilTest {
    @Test
    public void test01(){
        List<Person> list = new ArrayList();
        list.add(new Person("aaa", 18, "男", true));
        list.add(new Person("bbb", 19, "女", true));
        list.add(new Person("ccc", 20, "女", false));
        list.add(new Person("ddd", 21, "男", true));
        list.add(new Person("eee", 22, "男", true));
        List<List<Person>> result1 = CollectionUtil.partition1(list, 2);
        List<List<Person>> result2 = CollectionUtil.partition2(list, 4);
        System.out.println(result1);
        System.out.println(result2);
    }

}