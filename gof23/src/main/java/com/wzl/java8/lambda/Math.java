package com.wzl.java8.lambda;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/12/1 10:33
 */
public class Math {
    public static final Integer CONSTANT = 666;

    public int compute() {
        int a = 3;
        int b = 5;
        int c = (a + b) * 10;
        int d = CONSTANT + a;
        return c;
    }

    public static void main(String[] args) {
//        Math math = new Math();
//        math.compute();
//        Executors.newSingleThreadExecutor();
//        Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool();
//        Executors.newScheduledThreadPool();
//        Executors.newSingleThreadScheduledExecutor();
//        Executors.newWorkStealingPool();

        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
