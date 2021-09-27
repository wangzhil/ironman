package com.wzl.share.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 枷锁
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/20 7:27
 */
public class Singleton3 {

    public static Singleton3 instance;

    private Singleton3() {}

    public synchronized static Singleton3 getInstance() {

/*        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }

    public static void main(String[] args) {
        int length = 20;
        final ExecutorService executorService = Executors.newFixedThreadPool(length);

        for (int i = 0; i < length; i ++) {
            executorService.execute(() -> System.out.println(Singleton3.getInstance()));
        }
    }
}
