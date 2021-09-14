package com.wzl.common.leetcode;

import org.apache.commons.lang3.ObjectUtils;

/**
 * 两数相加
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/12 17:09
 */
public class Title2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lr;

        while (ObjectUtils.isNotEmpty(l1.next)) {
            lr = new ListNode();
        }
        return l1;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        for (int i = 0; i < 6; i++) {
            listNode1 = new ListNode(9, listNode1);
        }
        ListNode listNode2 = new ListNode(9);
        for (int i = 0; i < 3; i++) {
            listNode2 = new ListNode(9, listNode2);
        }
        final ListNode listNode = new Title2().addTwoNumbers(listNode1, listNode2);
    }
}
