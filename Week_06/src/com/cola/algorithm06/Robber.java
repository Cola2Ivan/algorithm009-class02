package com.cola.algorithm06;

import java.util.Arrays;

public class Robber {
    //打家劫舍
    //动态规划的常规思路
    public static int rob1(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int N = nums.length;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k = 2; k <= N ; k++) {
            dp[k] = Math.max(dp[k-1],nums[k-1] + dp[k-2]);
        }
        return dp[N];
    }

    //进行了空间优化
    public static int rob2(int[] nums) {
        int prev = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.max(cur,prev+1);
            prev = cur;
            cur = temp;
        }
        return cur;
    }

    //打家劫舍2
    public static int robberII(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        return Math.min(rob1(Arrays.copyOfRange(nums,0,nums.length -1)),
                rob2(Arrays.copyOfRange(nums,1,nums.length)));
    }
    /**
     * 动态规划总结：
     * 1、打家劫舍问题，是一维的动态规划，首先是分解问题为子问题，然后写出动态规划方程
     * 2、然后设定计算顺序，需要理解自顶而下，自底向上两种计算方式
     * 3、节省空间的方式是，从底向上的方式，这里的底指的是从已知量f(0)递推到f(1)的过程
     * */
}
