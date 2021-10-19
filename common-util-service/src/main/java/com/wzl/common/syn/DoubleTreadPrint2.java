package com.wzl.common.syn;

import java.util.concurrent.CountDownLatch;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/19 8:32
 */
public class DoubleTreadPrint2 {

    static Object obj= new Object();

    public static void main(String[] args) {
        char[] abc = "ABCDEFGH".toCharArray();
        char[] one = "12345678".toCharArray();
        CountDownLatch cdl = new CountDownLatch(1);
        Thread t1,t2;

        t1 = new Thread(() -> {
            for (char a : abc) {
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj) {
                    System.out.println(a);
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2 = new Thread(() -> {
            for (char o : one) {
                synchronized (obj) {
                    System.out.println(o);
                    // 控制谁先执行
                    cdl.countDown();
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
