package com.wzl.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和  1： 首先进行所有数组数据的排序。
 *          2： 根据两数之间关系，对nums[i]表达的连续3个数不能都大于0 和 去重处理。
 *          3：u如果 nums[left] == nums[right] 则加入list并且过滤左右接下来重复数据，。
 *          4. 不等分 两数和 < 目标sum 和大于目标sum。排除类似 -1 -1 0 1先从right -- 后就没有数据的情况。
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/10 16:25
 */
public class P15ThreeSum {

    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        System.out.println(solution.threeSum(new int[]{1,-1,-1,0}));;
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] num) {
            //先对数组进行排序
            Arrays.sort(num);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < num.length - 2; i++) {
                //过滤掉重复的
                if (i > 0 && num[i] == num[i - 1])
                    continue;
                //因为是排序的，如果第一个数字大于0，那么后面的也都
                //大于0，他们三个数字的和不可能等于0
                if (num[i] > 0)
                    break;
                int left = i + 1;//左指针
                int right = num.length - 1;//右指针
                int target = -num[i];
                while (left < right) {
                    //左右指针的和
                    int sum = num[left] + num[right];
                    if (sum == target) {
                        //找到了一组，把他们加入到集合list中
                        res.add(Arrays.asList(num[i], num[left], num[right]));
                        //过滤掉重复的
                        while (left < right && num[left] == num[left + 1])
                            left++;
                        while (left < right && num[right] == num[right - 1])
                            right--;
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return res;
        }
    }
}
