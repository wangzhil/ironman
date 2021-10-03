package com.wzl.algorithm.leetcode;

/**
 * 反转链表
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/3 19:40
 */
public class EasyFanZhuanLianBiaoLcof {

    public static void main(String[] args) {
        Solution solution = new EasyFanZhuanLianBiaoLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {

            ListNode pre = null;
            ListNode curr = head;
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
