package com.cola.algorithm;

import java.util.*;

//todo：尽量再做5~6题
public class GreedyAlgorithm {

    //柠檬水，5块一瓶 只收5元 10元 20元
    public static boolean lemonadeChange(int[] bills) {
        if (bills.length == 0) {
            return false;
        }
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else if (bills[i] == 20) {
                if (ten > 0 && five > 0) {
                    ten = ten - 1;
                    five = five - 1;
                } else if (five > 3) {
                    five = five - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //购买股票问题
    //不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
    //1 <= prices.length <= 3 * 10 ^ 4
    //0 <= prices[i] <= 10 ^ 4
    //note 重点是需要理解这一题为什么使用贪心算法，和贪心算法的思想。
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int price = prices[i + 1] - prices[i];
            if (price > 0) {
                max = max + price;
            }
        }

        return max;
    }

    //分发饼干
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int child = 0;
        int content = 0;
        while (child < g.length && content < s.length) {
            if (g[child] <= s[content]) {
                child++;
                res++;
            }
            content++;
        }
        return res;
    }

    //模拟行走机器人
    public static int robotSim(int[] commands, int[][] obstacles) {
        //首先有循环获取到每一步的command
        //二维数组obstacles表示一维行为x坐标,二维行为y坐标
        int curX = 0;
        int curY = 0;
        int curState = 0;//0：正北，1：正西，2：正南，3：正东
        int max = 0;
        Set<String> set = new HashSet<>();
        for(int i =  0 ;i < obstacles.length; i++){
            set.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];
            if (command == -2) {
                curState = switchLeft(curState);
            } else if (command == -1) {
                curState = switchRight(curState);
            } else {
                for(int j = 0; j <command; j++){
                    boolean nextLoop = false;
                    switch (curState) {
                        case 0: //正北
                            if (set.contains(curX+","+ (curY + 1))){
                                nextLoop = true;
                                break;
                            }
                            curY = curY + 1;
                            break;
                        case 1: //正西
                            if (set.contains((curX -1)+","+ curY)) {
                                nextLoop = true;
                                break;
                            }
                            curX = curX - 1;
                            break;
                        case 2:  //正南
                            if (set.contains(curX+","+ (curY - 1))) {
                                nextLoop = true;
                                break;
                            }
                            curY = curY - 1;
                            break;
                        case 3: //正东
                            if (set.contains((curX -1)+","+ curY)) {
                                nextLoop = true;
                                break;
                            }
                            curX = curX + 1;
                            break;
                    }
                    if(nextLoop){
                        break;
                    }
                }
                max = Math.max(max, curX *curX + curY * curY);
            }
        }
        return max;
    }

    private static int switchLeft(int curState) {
        switch (curState) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 0;

        }
        return curState;
    }

    private static int switchRight(int curState) {
        switch (curState) {
            case 0:
                return 3;
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;

        }
        return curState;
    }


    //单词接龙


    public static void main(String[] args) {
//        int[] bills = new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
//        System.out.println("可以找零？" + lemonadeChange(bills));
//
//        int[] prices = new int[]{7,6,4,3,1};
//        System.out.println("股票收益率最高：" + maxProfit(prices));

//        int[] child = new int[]{10, 9, 8, 7};
//        int[] chip = new int[]{5, 6, 7, 8};
//        System.out.println("饼干" + findContentChildren(child, chip));


        //[7,-2,-2,7,5]
        //[[-3,2],[-2,1],[0,1],[-2,4],[-1,0],[-2,-3],[0,-3],[4,4],[-3,3],[2,2]]
//        int[] steps = new int[]{7,-2,-2,7,5};
//        int[][] ob = new int[][]{{-3,2},{-2,1},{0,1},{-2,4},{-1,0},{-2,-3},{0,-3},{4,4},{-3,3},{2,2}};
//        System.out.println("result" + robotSim(steps, ob));

    }

    //简单：
    //柠檬水找零（亚马逊在半年内面试中考过）
    //买卖股票的最佳时机 II （亚马逊、字节跳动、微软在半年内面试中考过）
    //分发饼干（亚马逊在半年内面试中考过）
    //模拟行走机器人
    //使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
    //说明：同学们可以将自己的思路、代码写在第 4 周的学习总结中
    //中等：
    //单词接龙（亚马逊在半年内面试常考）
    //岛屿数量（近半年内，亚马逊在面试中考查此题达到 350 次）
    //扫雷游戏（亚马逊、Facebook 在半年内面试中考过）
    //跳跃游戏 （亚马逊、华为、Facebook 在半年内面试中考过）
    //搜索旋转排序数组（Facebook、字节跳动、亚马逊在半年内面试常考）
    //搜索二维矩阵（亚马逊、微软、Facebook 在半年内面试中考过）
    //寻找旋转排序数组中的最小值（亚马逊、微软、字节跳动在半年内面试中考过）
    //困难
    //单词接龙 II （微软、亚马逊、Facebook 在半年内面试中考过）
    //跳跃游戏 II （亚马逊、华为、字节跳动在半年内面试中考过）

}
