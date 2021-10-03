package com.wzl.algorithm.lagou;

import java.util.Stack;

/**
 * 每日温度
 *
 * @author: wangzhilei
 * @version: 1.0.0
 * @date: 2021/10/3 13:17
 */
public class P739DailyTemperatures {

    public static void main(String[] args) {

        new Solution().dailyTemperatures(new int[]{13, 24, 25, 21, 19, 22, 26, 23});

    }

}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] re = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i ++) {
            if (i == 0) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int pop = stack.pop();
                re[pop] = i - pop;
            }
            stack.push(i);
        }
        return re;
    }

}
