package com.wzl.algorithm.leetcode;

/**
 * 最长回文子串
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/10 9:40
 */
public class P5LongestPalindromicSubstring {

    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("babad");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() < 2) {
                return s;
            }
            char[] chars = s.toCharArray();
            int left; int right; int max = 0; int length = s.length(); int start = 0;
            for (int i = 0; i < length;) {
                left = i; right = i;
                while (right < length - 1 && chars[right] == chars[right + 1]) {
                    right ++;
                }
                i = right + 1;
                while (left > 0 && right < length - 1 && chars[left - 1] == chars[right + 1]) {
                    left--;
                    right ++;
                }
                if (right - left + 1 > max) {
                    max = right -left + 1;
                    start = left;
                }
            }

            return s.substring(start, start + max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
