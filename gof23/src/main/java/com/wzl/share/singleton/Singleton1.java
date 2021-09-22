package com.wzl.share.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 饿汉式基础版本 类加载就会导致实例对象创建，如果大量单例对象启动加载，会让内存爆炸
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/19 23:21
 */
public class Singleton1 {

    private static Singleton1 instance = new Singleton1();

    private Singleton1() {
    }
    public static Singleton1 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        int length = 20;
        final ExecutorService executorService = Executors.newFixedThreadPool(length);

        for (int i = 0; i < length; i ++) {
            executorService.execute(() -> System.out.println(Singleton1.getInstance()));
        }
    }
}
