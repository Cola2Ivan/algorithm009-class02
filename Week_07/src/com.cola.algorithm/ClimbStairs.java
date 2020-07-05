package com.cola.algorithm;

public class ClimbStairs {
    public static int climbStairs(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n ==2){
            return 2;
        }
        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        int i = 3;
        while( i <= n){
            f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
            i++;
        }
        return f3;
    }

    public static int climbStairsFB(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n ==2){
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("dp 爬楼梯" + climbStairs(10));
    }
}
