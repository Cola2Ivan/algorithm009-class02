package com.cola.algorithm08;

public class NQueueBit {
    /**
     * 题号52 N皇后II
     * 位运算解法
     *
     * @see {https://leetcode-cn.com/problems/n-queens-ii/description/}
     */
    private static int size;
    private static int count;

    public static void solve(int row, int ld, int rd) {
        if (row == size) {
            count++;
            return;
        }
        //确定放置位置，从头到尾
        //当前层，因为row ld rd分别占不同的位，所以使用|
        //pos确定可以使用的位置
        int pos = size & (~(row | ld | rd));

        while (pos != 0) {
            //获取低位1所代表的数，也就是当前所在位置
            //加上while循环就是去遍历每一个可用的位置
            int p = pos & (-pos);
            pos -= p;
            //row表示已经占用的位置表示列不可用，row的变化是0->1->2->4->8,因为是用位来表示占用位置，数值显式就为2^n的形式
            //ld|p当前层已经占用的位置，左移是到下一层不可用的位置,数值显示和row类似
            //rd|p当前层已经占用的位置，右移下一层不可用的位置，数值显示和row类似
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

    public static int totalNQueues(int n) {
        count = 0;
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueues(4));
    }
}
