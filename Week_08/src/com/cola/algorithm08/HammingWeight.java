package com.cola.algorithm08;

public class HammingWeight {
    /**
     * 题号191 位1的个数
     *
     * @see {https://leetcode-cn.com/problems/number-of-1-bits/}
     */
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            //n&(n-1)将最后一位的1翻转掉
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
