package com.wzl.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if (s.length() == 0)
            return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            //因为题中说了，只考虑字母和数字，所以不是字母和数字的先过滤掉
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            //然后把两个字符变为小写，在判断是否一样，如果不一样，直接返回false
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }


}
