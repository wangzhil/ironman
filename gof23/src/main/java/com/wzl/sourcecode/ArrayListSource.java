package com.wzl.sourcecode;

/**
 * 手写ArrayList扩容
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/12/18 7:56
 */
public class ArrayListSource<E> {

    public static void main(String[] args) {

    }

    private int size;
    private int modCount;
    private Object[] elementData;

    public boolean add(E element) {
        // 1. 是否扩容
        ensureCapacityInternal(size);
        // 2. 长度size自增
        elementData[size++] = element;
        return true;
    }

    private void ensureCapacityInternal(int capacity) {
        int minCapacity;
        if (capacity == 0) {
            minCapacity = 10;
        } else {
            minCapacity = ++capacity;
        }
        if (minCapacity > size) {
            grow(minCapacity);
        }
        size++;
        modCount++;
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + oldCapacity >> 1;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        Object[] obj = new Object[newCapacity];
        System.arraycopy(elementData, 0, obj, 0, elementData.length);
        elementData = obj;
    }
}
