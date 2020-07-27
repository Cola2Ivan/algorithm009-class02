package com.cola.algorithm09;

public class MinPathSum {
    /**
     * 题号：64 最小路径和问题
     *
     * @see {https://leetcode-cn.com/problems/minimum-path-sum/}
     * 每次只能向下或者向右移动一步
     */
    public static int minPathSum(int[][] grid) {
        //边界值判断
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        //dp状态定义
        //说明，dp[i][j]表示当前格子的最小路径和
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //边界状态方程
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                //顶部
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    continue;
                }
                //左侧
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    continue;
                }
                //dp状态转移方程
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(nums));
    }
}
