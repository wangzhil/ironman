package com.wzl.gof23.structrue.decorator;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/6 8:53
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Garnish garnish = new Egg(new FiredNoodles(15, 2), 5, 3);
        System.out.println(garnish.getCost());
    }
}
