package com.wzl.algorithm.leetcode;


/**
 * 环形链表
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/3 8:46
 */
public class BaseHasCycle {

    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
