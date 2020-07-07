package com.cola.algorithm;
/**
 * 有效的数独 题号：36
 * */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] subBox = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int sboxIndex = (i / 3) * 3 + j / 3;
                    //检查行
                    if (rows[i][num] == 1) {
                        return false;
                    } else {
                        rows[i][num] = 1;
                    }
                    //检查列
                    if (cols[i][num] == 1) {
                        return false;
                    } else {
                        cols[i][num] = 1;
                    }
                    //检查子方格
                    if (subBox[sboxIndex][num] == 1) {
                        return false;
                    } else {
                        subBox[sboxIndex][num] = 1;
                    }

                }
            }
        }
        return true;
    }

}
