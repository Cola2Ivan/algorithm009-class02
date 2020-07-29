package com.cola.algorithm09;

public class LongestValidParentheses {

    /**
     * 题号32 最长有序括号
     *
     * @see {https://leetcode-cn.com/problems/longest-valid-parentheses/}
     */
    public static int longestValidParentheses(String s) {

        int len = s.length();
        if (len < 2) {
            return 0;
        }
        //状态定义
        int dp[] = new int[len];
        dp[0] = 0;
        int maxans = dp[0];
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (s.charAt(i - 1) == '(') {
                    //如果匹配到左括号
                    if (i >= 2) {
                        //查看之前的数据是否还是可以延长
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    //"((())" i-1为右括号时， dp[i-1]表示，可能存在前边的子序列有序的个数，i-dp[i-1] --> 前序长度判断
                    //i-dp[i-1] -1是假定i-1为右括号并存在最长子序列时，那么i-dp[i-1]-1位置的括号应该为左括号
                    //查看当前i-1最长子序列之前的序列是否还可以延长，所以i-dp[i-1] -2 获取i-1之前的序列最长匹配子序列
                    //后边的+2代表i位置匹配到所以+2
                    int nextRightPos = i - dp[i - 1] - 2;
                    if (nextRightPos >= 0) {
                        //i-dp[i-1] -2是寻找
                        dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String lenStr = ")()())";
        System.out.println(longestValidParentheses(lenStr));
    }
}
