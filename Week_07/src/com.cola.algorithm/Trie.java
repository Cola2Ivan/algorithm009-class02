package com.cola.algorithm;

class Trie {

    //定义Trie树节点
    class TrieNode {

        private final int count = 26;

        private TrieNode[] trieNodes;

        private boolean isEnd = false;

        public TrieNode() {
            trieNodes = new TrieNode[count];
        }

        public boolean containKey(int position) {
            if (trieNodes == null) {
                return false;
            }
            return trieNodes[position] != null;
        }

        public TrieNode getTrieNodeByIndex(int position) {
            return trieNodes[position];
        }

        public void putNodeByPosition(int position, TrieNode trieNode) {
            trieNodes[position] = trieNode;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }


    }

    //构建根节点
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null) {
            return;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int position = getCharIndex(word.charAt(i));
            if (!node.containKey(position)) {
                node.putNodeByPosition(position, new TrieNode());
            }
            node = node.getTrieNodeByIndex(position);
        }
        node.setEnd(true);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!= null && node.isEnd();
    }

    private TrieNode searchPrefix(String word){
        if (word == null) {
            return null;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int position = getCharIndex(word.charAt(i));
            if (node.containKey(position)) {
                node = node.getTrieNodeByIndex(position);
            }else {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private int getCharIndex(char character) {
        return character - 'a';
    }
}