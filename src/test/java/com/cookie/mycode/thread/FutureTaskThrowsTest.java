package com.cookie.mycode.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.concurrent.*;

/**
 * @Type: Class
 * @Package: thread.basic
 * @Author: CookieWu
 * @Date: 2024/1/2 22:27
 * @User: admin
 * @Desc: 多线程FutureTask有返回值-异常被线程抛出的情况
 */
@Slf4j
public class FutureTaskThrowsTest {

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 8, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("直接拒绝...");
            }
        });

        System.out.println("主线程开始..." + System.currentTimeMillis());
        try {
            Apple21 apple = new Apple21("红苹果", new BigDecimal(10.00));
            FutureTask<BigDecimal> futureTask1 = new FutureTask<>(new T1(apple));
            FutureTask<BigDecimal> futureTask2 = new FutureTask<>(new T2(apple));
            threadPoolExecutor.execute(futureTask1);
            threadPoolExecutor.execute(futureTask2);
            BigDecimal p1 = futureTask1.get();
            BigDecimal p2 = futureTask2.get();
            System.out.println("p1 = " + p1);
            System.out.println("p1 = " + p2);
        } catch (Exception e){
            System.out.println("捕获到异常 -> " + e);
        }

        System.out.println("主线程快结束了..." + System.currentTimeMillis());
        TimeUnit.SECONDS.sleep(10);
        System.out.println("主线程结束..." + System.currentTimeMillis());
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class T1 implements Callable<BigDecimal> {
    Apple21 apple;
    @Override
    public BigDecimal call() throws Exception {
        System.out.println("t1线程开始..." + System.currentTimeMillis());
        BigDecimal price = apple.getPrice();
        BigDecimal price1 = price.add(new BigDecimal(3.00));
        TimeUnit.SECONDS.sleep(3);
        int i = 1/0;
        System.out.println("t1线程结束..." + System.currentTimeMillis());
        return price1;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class T2 implements Callable<BigDecimal> {
    Apple21 apple;
    @Override
    public BigDecimal call() throws Exception {
        System.out.println("t2线程开始..." + System.currentTimeMillis());
        BigDecimal price = apple.getPrice();
        BigDecimal price1 = price.add(new BigDecimal(5.00));
        TimeUnit.SECONDS.sleep(5);
        int i = 1/0;
        System.out.println("t2线程结束..." + System.currentTimeMillis());
        return price1;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Apple21{
    private String name;
    private BigDecimal price;
}
