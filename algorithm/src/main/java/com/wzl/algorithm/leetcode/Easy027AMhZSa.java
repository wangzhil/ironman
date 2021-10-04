package com.wzl.algorithm.leetcode;

/**
 * 回文链表
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/3 23:11
 */
public class Easy027AMhZSa {

    public static void main(String[] args) {
        Solution solution = new Easy027AMhZSa().new Solution();

        solution.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (null != fast && null != fast.next) {
                fast = fast.next.next;
                slow = slow.next;
            }
            if (fast != null) {
                slow = slow.next;
            }
            slow = reviseListNode(slow);
            fast = head;
            while (null != slow) {
                if (fast.val != slow.val) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next;
            }
            return true;
        }

        public ListNode reviseListNode(ListNode slow) {
            ListNode pre = null;
            ListNode curr = slow;
            ListNode nex = null;
            while (null != curr) {
                nex = curr.next;
                curr.next = pre;
                pre = curr;
                curr = nex;
            }
            return pre;
        }
    }
}
