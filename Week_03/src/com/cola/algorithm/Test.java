package com.cola.algorithm;

import java.util.ArrayList;
import java.util.List;

//常见回溯算法
//todo 有重复数的全排列
public class Test {

    public static void main(String[] args) {
        //斐波那契数列
//        int n = 10;
//        System.out.println("n " + n + ", result= " + solve(n));

        //括号匹配问题
//        testMarch(0,0,3,"");

        //全排列
//        permute(new int[]{1, 2, 3,4});

        //有重复数的全排列
        permute2(new int[]{1, 1, 3,4});

        //组合问题
//        System.out.println("combine result:" + combine(6, 2));

    }

    //动态规划 斐波那契数，公式 f(n) = f(n-1) + f(n-2)
    private static int solve(int n) {
        if (n == 1) {
            return n;
        }
        if (n == 2) {
            return 2;
        }
        int i = 2;
        int f1 = 1;
        int f2 = 2;
        int f3 = f2 + f1;
        while (i < n) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
            System.out.println("-middle->" + f3);
            i = i + 1;
        }
        return f3;
    }

    //求括号问题
    private static void testMarch(int left, int right, int n, String s) {
        //寻找终止条件
        if (left == n && right == n) {
            System.out.println(s);
            return;
        }
        //初始化起始状态
        //s +“（”
        //s+“)”

        //最小子问题
        if (left < n) {
            testMarch(left + 1, right, n, s + "(");
        }
        if (left > right) {
            testMarch(left, right + 1, n, s + ")");
        }
        //清除状态
    }

    //给定一个 没有重复 数字的序列，返回其所有可能的全排列
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> visitor = new ArrayList<>();
        solvePermute(nums, result, visitor);

        System.out.println("result->" + result);
        return result;
    }

    private static void solvePermute(int[] nums, List<List<Integer>> result, List<Integer> visitor) {
        //终止条件
        if (visitor.size() == nums.length) {
            result.add(new ArrayList<>(visitor));
            return;
        }

        //最小子问题
        for (int i = 0; i < nums.length; i++) {
            //第k个数作为第一个数
            if (!visitor.contains(nums[i])) {
                visitor.add(nums[i]);
                //对后续的数列排序
                solvePermute(nums, result, visitor);
                //重置数组状态
                visitor.remove(visitor.size() - 1);
            }

        }
    }

    //给定一个有重复 数字的序列，返回其所有可能的全排列
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> visitor = new ArrayList<>();
        solvePermute2(nums, result, visitor);

        System.out.println("result->" + result);
        return result;
    }

    private static void solvePermute2(int[] nums, List<List<Integer>> result, List<Integer> visitor)  {
        //终止条件
        if (visitor.size() == nums.length) {
            result.add(new ArrayList<>(visitor));
            return;
        }

        //最小子问题
        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i-1] == nums[i] && visitor.contains(nums[i -1]) ){
                visitor.add(nums[i-1]);
                continue;
            }
            //第k个数作为第一个数
            if (!visitor.contains(nums[i])) {
                visitor.add(nums[i]);
                //对后续的数列排序
                solvePermute2(nums, result, visitor);
                //重置数组状态
                visitor.remove(visitor.size() - 1);
            }

        }
    }

    //组合问题 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        solveCombine(n, k, 1, result, new ArrayList<Integer>());
        return result;
    }

    private static void solveCombine(int n, int k, int next, List<List<Integer>> result, List<Integer> combineList) {
        //终止条件
        if (combineList.size() == k) {
            result.add(new ArrayList<>(combineList));
            return;
        }

        //最近子问题
        for (int i = next; i < n + 1; i++) {
            combineList.add(i);
            solveCombine(n, k, i + 1, result, combineList);
            combineList.remove(combineList.size() - 1);
        }
        //状态修改
    }

}
