package com.wzl.algorithm.lagou;

/**
 * 滑动窗口最大值
 * 双端队列，将最大值放入队列最底部，比较新值，如果大于则替换弹出。继续比较，一直保持最左为最大。如果队列count > k， 则弹出最左端。
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/3 14:15
 */
public class P239SlidingWindowMaximum {

    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();

        solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            return new int[12];
        }
    }
}
