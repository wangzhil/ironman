package com.wzl.gof23.structrue.flyweight;

/**
 * Test
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/10 10:40
 */
public class Test {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "he" + "llo";
        String s4 = "hel" + new String("lo");
        String s5 = new String("hello");
        String s6 = s5.intern();
        String s7 = "h";
        String s8 = "ello";
        String s9 = s7 + s8;
        
    }
}
