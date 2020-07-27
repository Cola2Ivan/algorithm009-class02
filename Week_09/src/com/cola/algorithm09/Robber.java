package com.cola.algorithm09;

public class Robber {
    /**
     * 题号198 打家劫舍
     * @see {https://leetcode-cn.com/problems/house-robber/}
     * @see com.cola.algorithm06.Robber 引用的处理方式逻辑有问题
     * */
    public static int rob(int[] nums) {
        if(nums.length  == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }

        //定义状态数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        return dp[nums.length -1];
    }
    /**
     * 题号198 打家劫舍空间优化
     * @see {https://leetcode-cn.com/problems/house-robber/}
     * */
    public static int rob_Opt(int[] nums){
        if(nums.length  == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }

        //定义状态数组
        int pre = nums[0];
        int cur = Math.max(nums[0],nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(cur,pre + nums[i]);
            pre = cur;
            cur = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(rob(nums));
    }

}
