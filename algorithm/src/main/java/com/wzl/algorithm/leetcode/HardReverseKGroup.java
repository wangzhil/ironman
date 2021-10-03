package com.wzl.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * K个一组翻转列表
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/3 9:29
 */
public class HardReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (true) {
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if (count != k) {
                p.next = head;
                break;
            }
            while (!stack.isEmpty()){
                p.next = stack.pollLast();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return dummy.next;
    }

}

