package com.cookie.mycode.utils.basic;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Desc:
 * @Author: CookieWu
 * @Date: 2023/10/16 14:46
 * @Version: v1.0
 */
public class CollectionUtil {
    /**
     * 将集合按照自定长度区间切割 - 方法1
     * @param source
     * @param length
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> partition1(List<T> source, int length) {
        if (CollectionUtils.isEmpty(source) || length <= 0){
            return null;
        }
        List<List<T>> result = new ArrayList<>();
        Iterator<T> it = source.iterator();
        List<T> subList = null;
        while (it.hasNext()) {
            if (subList == null) {
                subList = new ArrayList<>();
            }
            T t = it.next();
            subList.add(t);
            if (subList.size() == length) {
                result.add(subList);
                subList = null;
            }
        }
        //补充最后一页
        if (subList != null) {
            result.add(subList);
        }
        return result;
    }

    /**
     * 将集合按照自定长度区间切割 - 方法2
     * @param source
     * @param length
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> partition2(List<T> source, int length) {
        if (CollectionUtils.isEmpty(source) || length <= 0){
            return null;
        }
        List<List<T>> result = new ArrayList<>();
        //原集合长度
        int size = source.size();
        //取商
        int num = size / length;
        //取余
        int rem = size % length;
        for (int i = 0; i < num; i++) {
            List<T> value = source.subList(i * length, (i + 1) * length);
            result.add(value);
        }
        //补充最后一个区间
        if (rem > 0){
            List<T> remValue = source.subList(size - rem, size);
            result.add(remValue);
        }
        return result;
    }
}
