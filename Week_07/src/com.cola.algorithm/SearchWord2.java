package com.cola.algorithm;

import java.util.ArrayList;
import java.util.List;

public class SearchWord2 {

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        //先构建Trie前缀树
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        //边界值判别
        if (board == null) {
            return result;
        }
        if (board.length == 0) {
            return result;
        }
        if (board[0].length == 0) {
            return result;
        }
        //遍历board数组，对每个值进行dfs搜索
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfsSearch(board, row, col, trie.root, result);
            }
        }

        return result;
    }

    //深度优先遍历
    private static void dfsSearch(char[][] board, int row, int col, Trie.TrieNode node, List<String> result) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        char cur = board[row][col];
        if (cur == '$' || !node.containKey(cur - 'a')) {
            return;
        }
        node = node.getTrieNodeByIndex(cur - 'a');
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        char temp = board[row][col];

        board[row][col] = '$';
        dfsSearch(board, row - 1, col, node, result);
        dfsSearch(board, row + 1, col, node, result);
        dfsSearch(board, row, col - 1, node, result);
        dfsSearch(board, row, col + 1, node, result);
        board[row][col] = temp;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        System.out.println(findWords(board, words));
    }
}
