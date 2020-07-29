package com.cola.algorithm09;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxlRectangle {

    /**
     * 题号85 最大矩形
     *
     * @see {https://leetcode-cn.com/problems/maximal-rectangle/}
     * @see {https://leetcode-cn.com/problems/maximal-rectangle/solution/zui-da-ju-xing-by-leetcode/}
     * 解法三：使用栈的思想，把每一行看成了84题的方式来计算
     * 解法四：动态规划计算每一个点所代表的矩形的长宽高
     */
    public static int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(right, n);
        //  ["1","0","1","0","0"],
        //  ["1","0","1","1","1"],
        //  ["1","1","1","1","1"],
        //  ["1","0","0","1","0"]
        int maxareas = 0;
        for (int i = 0; i < m; i++) {
            int curLeft = 0;
            int curRight = n;
            //i行时点的高度
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }

            for (int j = 0; j < n; j++) {
                maxareas = Math.max(maxareas, (right[j] - left[j]) * height[j]);
            }
        }
        return maxareas;
    }

    public static void main(String[] args) {
        char[][] matric = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matric));
    }

    /**
     * 题号84 柱状图中的最大矩形
     * 因为和上题有相关性所以放在一起
     *
     * @see {https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode-/}
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {

            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }
                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }

    public static int largestRectangleAreaPrac(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        //左边界为栈顶元素所表示的下标和当前元素的位置
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && curHeight == heights[stack.peekLast()]) {
                    stack.pollLast();
                }
                int curWidth = 0;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }
                result = Math.max(result, curWidth * curHeight);

            }
            stack.addLast(i);
        }

        //栈中剩余的右边界为数组长度
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && curHeight == heights[stack.peekLast()]) {
                stack.pollLast();
            }
            int curWidth = 0;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.pollLast() - 1;
            }
            result = Math.max(result, curWidth * curHeight);
        }
        return result;
    }

}
