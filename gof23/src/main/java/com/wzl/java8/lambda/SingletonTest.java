package com.wzl.java8.lambda;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/12/1 8:25
 */
public class SingletonTest {

    public static SingletonTest INSTANCE;

    private SingletonTest(){}

    public static SingletonTest getInstance() {

        if (INSTANCE == null) {
            synchronized (SingletonTest.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonTest();
                }
            }
        }
        return INSTANCE;
    }
}
