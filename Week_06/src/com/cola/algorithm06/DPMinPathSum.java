package com.cola.algorithm06;

public class DPMinPathSum {

    //最小路径和
    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0 ){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for(int i = 0; i< row; i++){
            for(int j = 0;j < col;j ++){

                if(i == 0 && j == 0){
                    dp[0][0] = grid[0][0];
                    continue;
                }
                if(i == 0){
                    dp[0][j] = dp[0][j-1] + grid[0][j];
                    continue;
                }
                if(j == 0){
                    dp[i][0] = dp[i-1][0] + grid[i][0];
                    continue;
                }
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        //最小路径和
        int[][] grid = new int[][]{
                {1,3,1},{1,5,1},{4,2,1}};
        minPathSum(grid);
    }
}
