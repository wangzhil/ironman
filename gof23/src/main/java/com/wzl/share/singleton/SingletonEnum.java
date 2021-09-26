package com.wzl.share.singleton;

/**
 * 《Effective Java》推荐，单元素枚举类型经常成为实现单例的最佳方式
 * 如果该Singleton必须扩展一个超类。而不是扩展Enum的时候，则不宜使用。
 * 序列化和反序列化： 只是写入了枚举类的名字，没有任何对象的操作
 * 反射：当反射创建对象的时候，是枚举类型则抛出异常
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/20 10:09
 */
public enum SingletonEnum {
    /**
     *
     */
    INSTANCE;

    void doSomething() {
        System.out.println("我想做点啥，那到底做点啥");
    }

}
