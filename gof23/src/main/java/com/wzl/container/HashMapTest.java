package com.wzl.container;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试HashMap的不安全
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/12/15 16:59
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMapThread t1 = new HashMapThread();
        HashMapThread t2 = new HashMapThread();
        HashMapThread t3 = new HashMapThread();
        HashMapThread t4 = new HashMapThread();
        HashMapThread t5 = new HashMapThread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}

class HashMapThread extends Thread {

    private static AtomicInteger ai = new AtomicInteger();
    private Map<Integer, Integer> map = new HashMap<>();

    @Override
    public void run() {
        while (ai.get() < 1000000) {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
        }
    }
}
