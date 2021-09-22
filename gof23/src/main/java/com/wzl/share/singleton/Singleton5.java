package com.wzl.share.singleton;

/**
 * 加锁 双重检索外加volatile 保证可见性，防止指令重排序
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/20 7:27
 */
public class Singleton5 {

    public static volatile Singleton5 instance;

    private Singleton5() {}

    public static Singleton5 getInstance() {

        if (instance == null) {

            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Integer i = new Integer(6);
    }

}
