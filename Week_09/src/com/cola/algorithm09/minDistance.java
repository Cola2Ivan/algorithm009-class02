package com.cola.algorithm09;

public class minDistance {
    /**
     * 题号：72 编辑距离
     *
     * @see {https://leetcode-cn.com/problems/edit-distance/}
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        //构建dp状态数组
        //dp[i][j] 表示 word1 第i个字符转换到word2第j个字符子串需要的最小编辑距离
        int[][] dp = new int[m + 1][n + 1];
        //边界值赋值
        //左侧
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        //顶部
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }

        //动态规划方程
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //相等时，删除元素
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //不相等时，考虑三种变换中的最小编辑距离
                    //1、修改word1 dp[i-1][j] 2、修改word2 dp[i][j-1] 3、两个都修改dp[i-1][j-1]
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }
}
