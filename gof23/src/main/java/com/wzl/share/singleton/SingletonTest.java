package com.wzl.share.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 创建对象的方式有哪几种？ clone，new，反射，序列化

 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/20 9:27
 */
public class SingletonTest {


    @Test
    public void test() throws Exception {
        /*        final Singleton6 instance = Singleton6.getInstance();
        final Singleton6 instance1 = Singleton6.getInstance();
        System.out.println(instance1 == instance);*/

        // 反射破坏单例
        Constructor<SingletonEnum> constructor = SingletonEnum.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        final SingletonEnum singleton = constructor.newInstance();
        final SingletonEnum singleton1 = constructor.newInstance();
        System.out.println(singleton1 == singleton);

        System.out.println("============ 快乐的分界线 ============");

        // 序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
        // Singleton6
        oos.writeObject(SingletonEnum.INSTANCE);
        //Read Obj from file
        File file = new File("tempFile");
        ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
        // Singleton6
        SingletonEnum newInstance = (SingletonEnum) ois.readObject();
        //判断是否是同一个对象
        System.out.println(newInstance == SingletonEnum.INSTANCE);

        System.out.println("======== 快乐的分界线 =========");

        System.out.println(SingletonEnum.INSTANCE == SingletonEnum.INSTANCE);
        SingletonEnum.INSTANCE.doSomething();
    }

    @Test
    public void test1() {
        int sum = 100000000;
        StopWatch stopWatch = new StopWatch("单例创建耗时");
        stopWatch.start();
        for (int i = 0; i < sum; i++) {
            // 3002400 ns  2930100 ns  2938600 ns            饿汉式： 3ms
            // Singleton1 instance = Singleton1.getInstance();

            // 3768200 ns   4098800  3687800                 懒汉式:  3.8ms
            // Singleton2 instance = Singleton2.getInstance();

            // 1970473300 ns    1966795200 ns  1984560500 ns 方法锁: 1985ms
            // Singleton3 singleton3 = Singleton3.getInstance();

            // 3603300 ns  3393200 ns  3470400 ns            DC: 3.5ms
            // Singleton4 singleton4 = Singleton4.getInstance();

            // 20194600 ns  19174400 ns  19022000 ns         DCL : 20ms
            // Singleton5 singleton5 = Singleton5.getInstance();

            // 3168400 ns  3703600 ns  4103100 ns            静态内部类: 3.5ms
            // Singleton6 singleton6 = Singleton6.getInstance();

            // 2434400 ns  2270000 ns  1955700 ns            枚举: 2.2ms
            // SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        }
        stopWatch.stop();
        System.out.println(stopWatch.shortSummary());
    }
}
