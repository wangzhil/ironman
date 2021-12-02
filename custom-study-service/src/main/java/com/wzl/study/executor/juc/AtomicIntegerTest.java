package com.wzl.study.executor.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/11/27 19:00
 */
public class AtomicIntegerTest {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(1);
        i.incrementAndGet();
    }
}
