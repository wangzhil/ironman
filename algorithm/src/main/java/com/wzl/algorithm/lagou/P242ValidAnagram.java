package com.wzl.algorithm.lagou;

/**
 * 有效字母的异位词： 即长度相同，每个相同字母的数量也相同.
 * 另外一种算法是，先是判断长度不相同为false，然后排序两个char[]， 接着Arrays.equals比较是否相同结果
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/2 21:07
 */
public class P242ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        System.out.println(solution.isAnagram("ab", "a"));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            final char[] charsS = s.toCharArray();
            final char[] charsT = t.toCharArray();
            char[] arr = new char[26];
            for (char ss : charsS) {
                if (arr[ss % 'a'] != 0) {
                    arr[ss % 'a'] ++;
                    continue;
                }
                arr[ss % 'a'] = 1;
            }
            for (char tt : charsT) {
                if (arr[tt % 'a'] == 0) {
                    return false;
                }
                arr[tt % 'a'] --;
            }
            for (char r : arr) {
                if (r == 0) {
                    continue;
                }
                return false;
            }
            return true;
        }
    }

}
