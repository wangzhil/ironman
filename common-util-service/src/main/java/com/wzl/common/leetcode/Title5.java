package com.wzl.common.leetcode;

import java.util.Arrays;

/**
 * 旋转数组
 * 思路： 找到中位index，k % length 需要旋转的
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/15 8:59
 */
public class Title5 {

    public void rotate(int[] nums, int k) {
        final int length = nums.length;
        int[] temp = new int[length];
        final int i = k % length;

        for (int j = 0; j < length; j++) {
            if (j < length - i ) {
                temp[j + i] = nums[j];
            } else if (j >= length - i) {
                temp[i - (length - j)] = nums[j];
            }
        }
        for (int j = 0; j < length; j++) {
            nums[j] = temp[j];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        Arrays.stream(nums).forEach(System.out::println);
    }
}
