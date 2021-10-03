package com.wzl.algorithm.leetcode;

/**
 * 删除链表中的节点
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/3 18:02
 */
public class P237DeleteNodeInALinkedList {

    public static void main(String[] args) {
        Solution solution = new P237DeleteNodeInALinkedList().new Solution();
        solution.deleteNode(new ListNode(5));
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
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
