package com.wzl.common.syn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 和 synchronized的区别在于，syn的notify只有一个队列，叫醒服务只能叫醒队列里面随机一个。
 * 但是ReentrantLock绑定的Condition是可以多个condition，多个队列，精准唤醒。
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/19 8:50
 */
public class DTPReentrantLock {

    public static void main(String[] args) {

        char[] abc = "ABCDEFGH".toCharArray();
        char[] one = "12345678".toCharArray();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            for (char a : abc) {
                System.out.println(a);
                condition.signal();

                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            lock.unlock();
        }, "t1").start();
        new Thread(() -> {
            lock.lock();
            for (char o : one) {

                System.out.println(o);
                condition.signal();

                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }, "t2").start();
    }
}
