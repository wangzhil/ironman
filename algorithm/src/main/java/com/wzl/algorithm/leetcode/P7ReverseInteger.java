package com.wzl.algorithm.leetcode;

/**
 * 整数反转
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/8 8:55
 */
public class P7ReverseInteger {

    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
        System.out.println(solution.reverse(1534236469));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            long reverse = 0;
            while (x != 0) {
                reverse = x % 10 + reverse * 10;
                x = x / 10;
            }
            return (int) reverse == reverse ? (int) reverse : 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
