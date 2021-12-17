package com.wzl.sourcecode;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList的源码
 * 带参构造函数 和 不带参构造函数。 不带参，默认capacity为10， 每次扩容都是newLength + newLength >> 1.
 * 带参构造则 根据参数 int 的1.5倍。主要使用的是System.copyOf（1， 2， 3， 4， 5）方法
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/12/16 14:40
 */
public class ArrayListSourceCode {

    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 4};
//
//        int[] newArr = new int[10];
//        System.arraycopy(arr, 0, newArr, 0, arr.length);
//        System.out.println(newArr);
        // ArrayList的扩容是 newLength + newLength >> 1（向下取整）
        System.out.println(15 >> 1);


        List<String> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add(i + "");
        }
        for (int i = 11; i < 15; i++) {
            list.add(i + "");
        }
        list.get(10);
    }


    private int size;

    private int modCount;

    private Object[] elementNode;

    public ArrayListSourceCode() {

    }

    public boolean add(Object obj) {
        // 1. 判断是否扩容 如果elementData为空，直接默认10
        ensureCapacityInternal(size + 1);
        // 2.
        this.elementNode[size ++] = obj;
        return true;
    }

    private <E> void ensureCapacityInternal(int minCapacity) {
        int capacity;
        modCount ++;
        if ((elementNode == null)) {
            capacity = 10;
        } else {
            capacity = minCapacity;
        }
        if (capacity > elementNode.length) {

            Object[] newElement = new Object[capacity + capacity >> 1];
            System.arraycopy(elementNode, 0, newElement, 0, elementNode.length);
            elementNode = newElement;
        }
    }
}
