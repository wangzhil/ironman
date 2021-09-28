package com.wzl.share.flyweight;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/28 16:54
 */
public class DoTest {

    public static void main(String[] args) {

        String a = "hell";
        String b = "o";
        String ab = "hello";
        String aab = a + b;

        int m = 12;
        Integer i = new Integer(12);
        System.out.println(i == m);

        double x = 12;
        Double y = new Double(12);
        System.out.println(x == y);

    }
}
