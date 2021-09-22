package com.wzl.share.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * 创建对象的方式有哪几种？ clone，new，反射，序列化

 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/20 9:27
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {

/*        final Singleton6 instance = Singleton6.getInstance();
        final Singleton6 instance1 = Singleton6.getInstance();
        System.out.println(instance1 == instance);

        // 反射破坏单例
        Constructor<Singleton6> constructor = Singleton6.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        final Singleton6 singleton = constructor.newInstance();
        final Singleton6 singleton1 = constructor.newInstance();
        System.out.println(singleton1 == singleton);*/

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

        System.out.println(SingletonEnum.INSTANCE == SingletonEnum.INSTANCE);
        SingletonEnum.INSTANCE.doSomething();

    }
}
