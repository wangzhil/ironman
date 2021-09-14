package com.wzl.common.leetcode;

/**
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/9/14 22:45
 */
public class Title3 {

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(new Title3().singleNumber(nums));
    }
}
