package com.cookie.mycode.thread.threadlocal;

/**
 * @Desc:
 * @Author: CookieWu
 * @Date: 2024/3/22 13:44
 * @Version: v1.0
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> localVar = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "local_main";
        }
    };

    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        //清除本地内存中的本地变量
        localVar.remove();
    }
    public static void main(String[] args) throws InterruptedException {
        print("main");
        new Thread(new Runnable() {
            public void run() {
                ThreadLocalTest.localVar.set("local_A");
                print("A");
                //打印本地变量
                System.out.println("after remove : " + localVar.get());

            }
        },"A").start();

        Thread.sleep(1000);

        new Thread(new Runnable() {
            public void run() {
                ThreadLocalTest.localVar.set("local_B");
                print("B");
                System.out.println("after remove : " + localVar.get());

            }
        },"B").start();

    }
}