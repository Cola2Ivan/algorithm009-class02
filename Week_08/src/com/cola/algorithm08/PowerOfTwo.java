package com.cola.algorithm08;

public class PowerOfTwo {
    /**
     * 题号 231 2的幂
     *
     * @see {https://leetcode-cn.com/problems/power-of-two/}
     */
    public static boolean isPowerOfTwo(int n) {
        //是否是2的幂次，那么就是说位串中只有一个1，并且n>0
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2));
    }
}
