package com.cola.algorithm09;

public class MaxProfit {
    /**
     * 题号：121 买卖股票最佳时机
     * @see {https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/}
     * 只能进行一次买卖,所以需要找到升序的数值，先找最小值，再找最大差值。
     * */
    public static int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

    }
}
