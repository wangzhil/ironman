package com.wzl.common.leetcode;

import java.util.Arrays;

/**
 * 反转字符串
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/15 8:18
 */
public class Title4 {



    public void reverseString(char[] s) {
        int length = s.length;
        int left = 0;
        int right = length - left - 1;

        while (left < right) {
            swap(s, left ++ , right--);
        }
    }

    public void swap(char[] s, int left, int right) {
        /*char temp = s[left];
        s[left] = s[right];
        s[right] = temp;*/
        s[left] ^= s[right];
        s[right] ^= s[left];
        s[left] ^= s[right];
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        new Title4().reverseString(s);
        Arrays.asList(s).stream().forEach(System.out::println);
    }
}
