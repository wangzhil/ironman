package com.wzl.algorithm.leetcode;

/**
 * 回文字符串  这种方式是如此辣鸡
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/4 9:25
 */
public class EasyIsPalindrome {

    public static void main(String[] args) {
        String isPalindrome = "A man, a plan, a canal: Panama";
        System.out.println(new EasyIsPalindrome().isPalindrome(isPalindrome));
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        char[] chars = s.toCharArray();
        int l = s.length();
        int left = 0;
        int right = l - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
