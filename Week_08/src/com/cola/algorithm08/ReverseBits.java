package com.cola.algorithm08;

public class ReverseBits {
    /**
     * 题号：190 颠倒比特位
     *
     * @see {https://leetcode-cn.com/problems/reverse-bits/}
     */

    public static int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result = (result << 1) + (n & 1);
            n = n >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        reverseBits(7);
    }
}
