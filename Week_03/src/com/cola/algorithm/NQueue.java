package com.cola.algorithm;

import java.util.ArrayList;
import java.util.List;

public class NQueue {
    public static void main(String[] args) {
        System.out.println("NQueue result" +solveNQueens(5));
    }

    //N皇后问题 n*n的棋盘放置n个皇后，同行同列同斜线不可同线
    private static int[] queue;

    public static List<List<String>> solveNQueens(int n) {
        queue = new int[n];
        List<List<String>> result = new ArrayList<>();
        doNQueue(0, n, result);
        return result;
    }

    //描述为第row行放在哪一列
    public static void doNQueue( /*处理第几列*/int row, int n, List<List<String>> result) {
        if (row == n) {
            List<String> item = new ArrayList<>();
            for (int i = 0; i < queue.length; i++) {
                String resultStr = "";
                for (int j = 0; j < n; j++) {
                    if (j == queue[i] - 1) {
                        resultStr = resultStr + "Q";
                    } else {
                        resultStr = resultStr + ".";
                    }
                }
                item.add(resultStr);
            }
            result.add(item);
            return;
        }
        //当前处理问题
        for (/**/int col = 0; col < n; col++) {
            if (!isValid(row, col + 1)) {
                continue;
            }
            //放置皇后
            queue[row] = col + 1;
            //子问题
            doNQueue(row + 1, n, result);

            //重置放置
            queue[row] = 0;
        }

    }

    //判断是否可以放置
    private static boolean isValid(int row, int colAdd1) {
        for (int i = 0; i < row; i++) {
            if (queue[i] != 0 && (queue[i] == colAdd1 || (Math.abs(row - i) == Math.abs(colAdd1 - queue[i])))) {
                return false;
            }
        }
        return true;
    }
}
