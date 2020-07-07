package com.cola.algorithm;

import java.util.ArrayList;
import java.util.List;

public class NQueuePractice {
    private static int[] queue;
    public List<List<String>> solveNQueens(int n) {
        queue = new int[n];
        List<List<String>> result = new ArrayList<>();
        doNQueue(0,n,result);
        return result;
    }

    private void doNQueue(int row, int n, List<List<String>> result) {
        if(row == n){
            List<String> item = new ArrayList<>();
            for (int i = 0; i < queue.length; i++) {
                String resultStr = "";
                for (int j = 0; j < n; j++) {
                    if(j==queue[i] - 1){
                        resultStr = resultStr + "Q";
                    }else{
                        resultStr = resultStr + ".";
                    }
                }
                item.add(resultStr);
            }
            result.add(item);
            return;
        }

        for (int col = 0; col < n; col++) {
            if(!isValid(row,col+1)){ //检测是否可以放置剪枝条件
                continue;
            }
            queue[row] = col +1;
            doNQueue(row + 1, n, result);

            queue[row] = 0;
        }
        
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if(queue[i] != 0 && (queue[i] == col
                    || (Math.abs(row - i) == Math.abs(col - queue[i]) ))){
                return false;
            }
        }

        return true;
    }


}
