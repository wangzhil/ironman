package com.wzl.share.singleton;

/**
 * 加锁 避免锁的粒度过大，导致性能问题
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/20 7:27
 */
public class Singleton4 {

    public static Singleton4 instance;

    private Singleton4() {}

    public static Singleton4 getInstance() {

        if (instance == null) {

            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Integer i = new Integer(6);
    }

}
