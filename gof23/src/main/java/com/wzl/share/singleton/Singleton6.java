package com.wzl.share.singleton;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 静态内部类
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/20 9:20
 */
public class Singleton6 implements Serializable {

    static class InnerSingleton6 {
        public static Singleton6 instance = new Singleton6();
    }

    private Singleton6() {
        if (InnerSingleton6.instance != null) {
            throw new RuntimeException("Singleton not support Constructor");
        }
    }

    public static Singleton6 getInstance() {
        return InnerSingleton6.instance;
    }

    public static void main(String[] args) {
        int length = 20;
        final ExecutorService executorService = Executors.newFixedThreadPool(length);

        for (int i = 0; i < length; i ++) {
            executorService.execute(() -> System.out.println(Singleton6.getInstance()));
        }
    }

//    /**
//     * 解决序列化破坏单例
//     * Effective Java指出添加该方法即可解决单例破坏
//     * @return
//     */
//    private Object readResolve() {
//        return InnerSingleton6.instance;
//    }
}
