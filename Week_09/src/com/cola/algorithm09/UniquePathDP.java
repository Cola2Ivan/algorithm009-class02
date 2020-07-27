package com.cola.algorithm09;

public class UniquePathDP {

    /**
     * 题号62 不同路径问题
     * @see  {https://leetcode-cn.com/problems/unique-paths/}
     * */
    public static int uniquePaths(int m, int n) {

        //根据题目确定状态定义为二维dp数组
        int[][] dp= new int[m ][n];
        //初始化边缘状态
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        //确定动态规划方程
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }
}
