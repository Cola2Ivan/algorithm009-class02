package com.cola.algorithm09;

import java.util.Arrays;

public class LengthOfLIS {
    /**
     * 题号300 最长上升子序列
     *
     * @see {https://leetcode-cn.com/problems/longest-increasing-subsequence/}
     * @see {https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/}
     * 需要理解子序列和子串的区别
     */
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        //状态定义
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        //dp状态方程
        //遍历i之前的元素，只要i大于j位置的数，那么i就相对于j位置的最长子序列增加一位
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static int lengthOfLISPractice2(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        //状态定义
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }

        //状态转移方程
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}
