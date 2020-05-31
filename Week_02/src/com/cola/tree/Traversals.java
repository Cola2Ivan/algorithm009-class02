package com.cola.tree;

import java.util.ArrayList;
import java.util.List;

public class Traversals {

    //二叉树节点定义
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    //前序遍历
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preoder(root, result);
        return result;
    }

    private static void preoder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        if (root.left != null) {
            preoder(root.left, result);
        }
        if (root.right != null) {
            preoder(root.right, result);
        }
    }

    //中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inoder(root, result);
        return result;
    }

    private static void inoder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inoder(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            inoder(root.right, result);
        }
    }


    //N叉树节点
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static List<Integer> nPreorder(Node root) {
        List<Integer> result = new ArrayList<>();
        nPreOrder(root, result);
        return result;
    }

    private static void nPreOrder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        if (root.children == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            Node node = root.children.get(i);
            if (node != null) {
                nPreOrder(node, result);
            }
        }

    }


    public static void main(String[] args) {
        //构建二叉树
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(0);

        //前序测试
        List<Integer> preList = preorderTraversal(root);
        System.out.println("pre:" + preList);
        //中序测试
        List<Integer> inOrderList = inorderTraversal(root);
        System.out.println("inOrder:" + inOrderList);

        //构建n叉树遍历
        Node nRoot = new Node();
        nRoot.val = 1;
        List<Node> child1 = new ArrayList<>();
        child1.add(new Node(2));
        child1.add(new Node(5));
        child1.add(new Node(4));
        child1.add(new Node(6));
        child1.add(new Node(8));
        nRoot.children = child1;
        List<Node> child2 = new ArrayList<>();
        child2.add(new Node(7));
        child2.add(new Node(9));
        child2.add(new Node(10));
        child2.add(new Node(12));
        child2.add(new Node(11));
        nRoot.children = child2;
        //n叉树前序遍历
        List<Integer> nResult = nPreorder(nRoot);
        System.out.println("nResult:" + nResult);
    }

}
