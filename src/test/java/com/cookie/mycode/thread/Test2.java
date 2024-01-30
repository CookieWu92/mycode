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
 * @Desc:
 */
@Slf4j
public class Test2 {

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
            App app = new App();
            app.setName("王者荣耀");
            app.setSize(10000);
            Thread_Test2 t1 = new Thread_Test2(app);
            threadPoolExecutor.execute(t1);
        } catch (Exception e){
            System.out.println("捕获到异常 -> " + e);
        }

        System.out.println("主线程快结束了..." + System.currentTimeMillis());
        TimeUnit.SECONDS.sleep(10);
        System.out.println("主线程结束..." + System.currentTimeMillis());
    }
}

class Thread_Test2 extends Thread{
    private App app;
    public Thread_Test2(App app) {
        this.app = app;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始..." + System.currentTimeMillis());
        try {
            TimeUnit.SECONDS.sleep(5);
            app.setSize(app.getSize() + 100);
            int i = 1/0;
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + "线程内部异常...");
        }
        System.out.println(Thread.currentThread().getName() + "结束..." + System.currentTimeMillis());
    }
}

@Data
class App{
    String name;
    String desc;
    Integer size;
}
