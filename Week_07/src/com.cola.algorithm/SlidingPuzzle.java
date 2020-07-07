package com.cola.algorithm;

import java.util.*;

/**
 * 题号 773 滑动谜题
 */
public class SlidingPuzzle {
    //note:理解数组转字符串
    //BFS解法
    public int slidingPuzzleBFS(int[][] board) {
        //当0处于对应下标时，可以转换的位置，坐标变换向量
        int[][] dir = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        String end = "123450";
        String cur = toString(board);
        if (cur.equals(end)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(cur);
        Set<String> visited = new HashSet<>();
        visited.add(cur);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                cur = queue.poll();
                for (int i = 0; i < cur.length(); i++) {
                    if (cur.charAt(i) != '0') {
                        continue;
                    }
                    for (int op : dir[i]) {
                        char[] nexVal = cur.toCharArray();
                        swap(nexVal, i, op);
                        String next = new String(nexVal);
                        if (next.equals(end)) {
                            return count + 1;
                        }
                        if (visited.contains(next)) {
                            continue;
                        }
                        queue.offer(next);
                        visited.add(next);
                    }
                    break;
                }
            }
            count++;
        }
        return -1;
    }

    private void swap(char[] arr, int i, int op) {
        if (i != op) {
            char temp = arr[i];
            arr[i] = arr[op];
            arr[op] = temp;
        }
    }

    private String toString(int[][] board) {
        char[] value = new char[6];
        for (int i = 0; i < 6; i++) {
            value[i] = (char) (board[i / 3][i % 3] + '0');
        }
        return new String(value);
    }

    //A*启发式搜索
    public int slidingPuzzleAStar(int[][] board) {
        int[][] dir = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        int[] endBoard = {1, 2, 3, 4, 5, 0};
        Node curr = new Node(board);
        if (Arrays.equals(curr.board, endBoard)) {
            return 0;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(curr);
        HashSet<Node> visited = new HashSet<>();
        visited.add(curr);

        while (!queue.isEmpty()) {
            curr = queue.poll();
            for (int nextZeroPos : dir[curr.zeroPos]) {
                int[] nextBoard = Arrays.copyOf(curr.board, 6);
                swap(nextBoard, curr.zeroPos, nextZeroPos);
                if (Arrays.equals(nextBoard, endBoard)) {
                    return curr.count + 1;
                }
                Node next = new Node(nextBoard, nextZeroPos, curr.count + 1);

                if (visited.contains(next)) {
                    continue;
                }
                queue.offer(next);
                visited.add(next);
            }
        }
        return -1;
    }

    void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    class Node implements Comparable<Node> {
        int[] board;
        int zeroPos;
        int count;
        int distance;
        int f;

        public Node(int[][] board) {
            this.board = new int[6];
            for (int i = 0; i < 6; i++) {
                this.board[i] = board[i / 3][i % 3];
                if (this.board[i] == 0) {
                    this.zeroPos = i;
                }
            }
            this.count = 0;
            this.distance = calcDistance();
            this.f = this.count = this.distance;
        }

        public Node(int[] board, int zeroPos, int count) {
            this.board = board;
            this.zeroPos = zeroPos;
            this.count = count;
            this.distance = calcDistance();
            this.f = this.count + this.distance;
        }

        private int calcDistance() {
            int distance = 0;
            for (int i = 0; i < 6; i++) {
                int v = board[i] - 1;
                distance += Math.abs(v / 3 - i / 3) + Math.abs(v % 3 - i % 3);
            }
            return distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.f - o.f;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return zeroPos == node.zeroPos &&
                    Arrays.equals(board, node.board);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(zeroPos);
            result = 31 * result + Arrays.hashCode(board);
            return result;
        }
    }
}
