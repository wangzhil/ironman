package com.wzl.common.debug;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/18 22:06
 */
public class TestReentrantLock {

    private static  volatile  int i = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {

        } finally {
            lock.unlock();
        }



    }
}
