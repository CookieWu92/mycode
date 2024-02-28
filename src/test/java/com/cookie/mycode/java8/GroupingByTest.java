package com.cookie.mycode.java8;

import com.cookie.mycode.vo.Student;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Desc:
 * @Author: CookieWu
 * @Date: 2024/1/31 14:50
 * @Version: v1.0
 */
public class GroupingByTest {
    @Test
    public void Test1(){
        List<Student> students = Stream.of(
                Student.builder().name("小张").age(16).clazz("高一1班").course("历史").score(88).build(),
                Student.builder().name("小李").age(16).clazz("高一3班").course("数学").score(12).build(),
                Student.builder().name("小王").age(17).clazz("高二1班").course("地理").score(44).build(),
                Student.builder().name("小红").age(18).clazz("高二1班").course("物理").score(67).build(),
                Student.builder().name("李华").age(15).clazz("高二2班").course("数学").score(99).build(),
                Student.builder().name("小潘").age(19).clazz("高三4班").course("英语").score(100).build(),
                Student.builder().name("小聂").age(20).clazz("高三4班").course("物理").score(32).build()
        ).collect(Collectors.toList());

        Map<String, List<Student>> groupByCourse = students.stream().collect(Collectors.groupingBy(Student::getCourse));
        Map<String, List<Student>> groupByCourse1 = students.stream().collect(Collectors.groupingBy(Student::getCourse, Collectors.toList()));

        System.out.println(groupByCourse);
        System.out.println(groupByCourse1);
    }

}
