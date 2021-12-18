package com.wzl.algorithm.leetcode;

import java.util.Arrays;

/**
 * 旋转数组  1,2,3,4,5,6,7
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/12/18 10:17
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};
        new RotateArray().rotate(arr, 3);
        System.out.println(arr);

    }

    public void rotate(int[] nums, int k) {

        int length = nums.length;
        // 防止出现数据 1, 2   k为3实际只需要移动一次
        k = k % length;
        int[] right = Arrays.copyOfRange(nums, length - k, length);
        System.arraycopy(nums, 0, nums, k, length - k);
        System.arraycopy(right, 0, nums, 0, k);



        /*int length = nums.length;
        int[] temp = new int[length];

        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }

        for (int i = 0; i < length; i++) {
            nums[i + k % length] = temp[i];
        }
*/



        /*int length = nums.length;
        int[] temp = new int[length];

        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }

        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }*/
    }
}
