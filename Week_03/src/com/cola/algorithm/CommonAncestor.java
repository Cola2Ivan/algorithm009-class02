package com.cola.algorithm;

public class CommonAncestor {

    public static void main(String[] args) {
        System.out.println("lowest Common Ancestor:");
    }



    //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
    //note:首先要读懂该题目说的是保证该二叉树必定包含所求子节点
    //后序遍历查看子树是否包含孩子节点，
    //1、如果左右子树包含孩子节点，则根节点就是公共节点
    //2、如果左子树为空，则看说明元素在右子树,如果此时右子树为空，则该root节点下没有元素，倒回上次递归
    //3、右子树与左子树同理
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null ) return right;
        if (right == null ) return left;
        return root;
    }
}
