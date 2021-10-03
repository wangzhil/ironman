package com.wzl.algorithm.lagou;

/**
 * 删除链表的第N个节点
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/2 22:48
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int i = 0;
        ListNode first = head;
        ListNode end = head;
        while (i < n) {
            if ((first = first.next) == null) {
                return head.next;
            }
            i ++;
        }
        while (i >= n) {
            if ((first.next) == null) {
                end.next = end.next.next;
                break;
            }
            first = first.next;
            end = end.next;
            i ++;
        }
        return head;
    }

    public static void main(String[] args) {
        // 12345 1235
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        new RemoveNthFromEnd().removeNthFromEnd(head, 2);
        ListNode head = new ListNode(1, new ListNode(2));
        new RemoveNthFromEnd().removeNthFromEnd(head, 1);
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
