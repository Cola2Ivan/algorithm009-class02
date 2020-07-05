package com.cola.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    private static List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        doTravels(root, 0);
        return result;
    }

    //递归法
    private void doTravels(TreeNode node, int level) {
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);

        if (node.left != null) {
            doTravels(node.left, level + 1);
        }
        if (node.right != null) {
            doTravels(node.right, level + 1);
        }
    }

    //迭代法
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //一次队列中的长度就是一层的数据，这个思想真的好
        while (!queue.isEmpty()) {
            ArrayList<Integer> bfsRes = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                bfsRes.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(bfsRes);
        }
        return result;
    }

}
