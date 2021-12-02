package com.wzl.java8.lambda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/12/1 23:10
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 5; i++) {
//            threadPool.submit(() -> {
//
//                try {
//                    System.out.println("current thread name" + Thread.currentThread().getName());
//                    Object object = null;
//                    System.out.print("result## "+object.toString());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            });
//        }

/*        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Future future = executorService.submit(() -> {
                System.out.println("current thread name" + Thread.currentThread().getName());
                Object object = null;
                System.out.print("result## "+object.toString());
            });

            try {
                final Object o = future.get();
            } catch (Exception e) {
                System.out.println("发生异常");
            }
        }*/


        ExecutorService threadPool = Executors.newFixedThreadPool(1, r -> {
            Thread t = new Thread(r);
            t.setUncaughtExceptionHandler(
                    (t1, e) -> {
                        System.out.println(t1.getName() + "线程抛出的异常"+e);
                    });
            return t;
        });
        threadPool.execute(()->{
            Object object = null;
            System.out.print("result## " + object.toString());
        });

    }
}
