package com.wzl.sourcecode;

import java.util.Vector;

/**
 * Vector源码
 * 无参构造调有参构造，默认10；
 * 方法都加synchronized；
 * 扩容： oldCapacity + (指定扩容)capacityIncrement : old
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/12/16 19:43
 */
public class VectorSource {

    public static void main(String[] args) {
        Vector v = new Vector();
        v.add("1");
    }
}
