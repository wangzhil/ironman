package com.wzl.sourcecode;

/**
 * 手写链表学习
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/12/18 7:35
 */
public class LinkedSource<E> {

    public static void main(String[] args) {
        LinkedSource<String> str = new LinkedSource<>();
        str.add("1");
        str.add("2");
        System.out.println(str.removeFirst());
        System.out.println(str.size);
        System.out.println(str.modCount);
    }

    private Node<E> first;
    private Node<E> last;

    private int size;
    private int modCount;

    public boolean add(E element) {
        // 1. 添加就是尾添加
        addLast(element);

        return true;
    }

    public void addLast(E element) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, null, element);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    public E removeFirst() {
        Node<E> f = first;
        Node<E> next = f.next;
        E element = f.item;
        f.next = null;
        f.item = null;

        last = next;
        if (next == null) {
            first = null;
        } else {
            first = next;
        }
        size--;
        modCount++;
        return element;
    }


    static class Node<E> {
        private Node<E> prev;
        private Node<E> next;
        private E item;

        public Node(Node<E> prev, Node<E> next, E item) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }
}
