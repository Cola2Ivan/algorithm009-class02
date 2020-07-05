package com.cola.algorithm;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        addParenthesis(0, 0, n, "", result);
        return result;
    }

    private static void addParenthesis(int left, int right, int n, String s, List<String> result) {
        if (left == n && right == n) {
            result.add(s);
        }
        if (left < n) {
            addParenthesis(left + 1, right, n, s + "(", result);
        }
        //这里做了剪枝
        if (left > right && right < n) {
            addParenthesis(left, right + 1, n, s + ")", result);
        }
    }

    public static List<String> generateParenthesisDP(int n) {
        List<String> result = new ArrayList<>();
        if(n ==0){
            return result;
        }

        //动态规划状态
        List<List<String>> dp = new ArrayList<>();
        //初始态
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        //todo:还需要理解动态规划方式的流程。。。。
        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i-1-j);
                for (String s1:str1){
                    for (String s2 : str2) {
                        cur.add("(" + s1+")" + s2);
                    }
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
