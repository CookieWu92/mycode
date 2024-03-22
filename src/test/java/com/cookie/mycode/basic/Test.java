package com.cookie.mycode.basic;

import com.cookie.mycode.vo.Student;
import org.junit.platform.commons.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @org.junit.Test
    public void test3() {
        Integer integer1 = 300;
        Integer integer2 = 300;
        int int3 = 300;
        System.out.println(integer1 == integer2);
        System.out.println(integer1 == int3);
        System.out.println(integer1.equals(integer2));
        System.out.println(integer1.intValue() == integer2.intValue());
    }

    @org.junit.Test
    public void test04(){
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        System.out.println(a);
        for (String temp : a) {
            if("2".equals(temp)){
                a.remove(temp);
            }
        }
        System.out.println(a);
    }

    @org.junit.Test
    public void test05(){
        ArrayList<Student> students = new ArrayList<>();
        pullList(students, 5);
        for (int i = 0; i < students.size(); i++) {
            students.get(i).setName("aaa"+i);
        }
        System.out.println(students.size());
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getName());
        }
        System.out.println("=====================");

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student next = it.next();
            if ("aaa2".equals(next.getName())) {
                it.remove();
            }
        }
        System.out.println(students.size());
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getName());
        }
    }

    public void pullList(ArrayList<Student> list, int i){
        for (int j = 1; j <= i; j++) {
            Student student = new Student();
            list.add(student);
        }
    }
}
