package com.wzl.common.syn;

import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程互相打印
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/19 8:08
 */
public class DoubleThreadPrint {

    static Thread t1 = null,t2 = null;

    public static void main(String[] args) {
        char[] abc ="ABCDEFGH".toCharArray();
        char[] one = "12345678".toCharArray();

        t1 = new Thread(() -> {
            for (char a : abc) {
                System.out.println(a);
                LockSupport.unpark(t2);
                LockSupport.park(t1);
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char o : one) {
                LockSupport.park(t2);
                System.out.println(o);
                LockSupport.unpark(t1);
            }
        }, "t2");
        t1.start();
        t2.start();

    }
}
