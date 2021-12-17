package com.wzl.sourcecode;

import java.util.LinkedList;

/**
 * 双向链表源码
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/12/16 20:53
 */
public class LinkedListSource<E> {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        list.forEach(System.out::println);
        //
        list.removeFirst();

    }
    int size;
    int modCount;

    private Node<E> first;

    private Node<E> last;


    public E removeFirst() {
        Node<E> f = first;
        E e = unlinkFirst(f);
        return e;
    }

    private E unlinkFirst(Node<E> f) {
        E e = f.item;
        Node<E> next = f.next;

        f.prev = null;
        f.next = null;

        first = next;
        if (next  == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size --;
        modCount ++;
        return e;
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    void linkLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size ++;
        modCount ++;
    }


    private static class Node<E> {

        Node<E> prev;
        Node<E> next;
        E item;

        public Node(Node<E> l, E e, Node<E> next) {
            this.next = next;
            this.item = e;
            this.prev = l;
        }
    }



}
