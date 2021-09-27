package com.wzl.share.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 懒汉式   只有在使用的时候再加载
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/19 23:26
 */
public class Singleton2 {

    private static Singleton2 singleton2;

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
/*        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

    public static void main(String[] args) {
        int length = 20;
        final ExecutorService executorService = Executors.newFixedThreadPool(length);

        for (int i = 0; i < length; i ++) {
            executorService.execute(() -> System.out.println(Singleton2.getInstance()));
        }
    }
}
