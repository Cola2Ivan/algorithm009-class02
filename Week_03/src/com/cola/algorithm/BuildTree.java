package com.cola.algorithm;

import java.util.Arrays;

//根据中序遍历和前序遍历构建二叉树
public class BuildTree {
    //preorder = [3,9,20,15,7]
    //中序遍历 inorder = [9,3,15,20,7]
    public static void main(String[] args) {
        int[] preoder = new int[]{3,9,20,15,7};
        int[] inoder = new int[]{9,3,15,20,7};
        TreeNode node = buildTree(preoder,inoder);
        System.out.println(""+ node);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder== null || preorder.length ==0 || inorder == null || inorder.length == 0){
            return null;
        }
        if(preorder.length != inorder.length){
            throw new IllegalArgumentException("前中序数列长度应该相同");
        }
        //构建根节点
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        //如果列表中只有一个节点，则就是根节点直接返回
        if (preorder.length == 1){
            return root;
        }
        //遍历找到根节点位置
        int inOrPosition = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i]== rootVal){
                inOrPosition = i;
                break;
            }
        }
        //构建前序左右子树
        int[] leftTreeInOrder = Arrays.copyOfRange(inorder,0,(inOrPosition -1) < 0?0: inOrPosition);
        int[] rightTreeInOrder = Arrays.copyOfRange(inorder, Math.min((inOrPosition + 1), inorder.length),inorder.length);
        //构建后序左右子树
        int[] leftTreePreOrder = Arrays.copyOfRange(preorder,1,leftTreeInOrder.length +1);
        int[] rightTreePreOrder = Arrays.copyOfRange(preorder, Math.min(leftTreeInOrder.length + 1, preorder.length),preorder.length);
        root.left = buildTree(leftTreePreOrder,leftTreeInOrder);
        root.right = buildTree(rightTreePreOrder,rightTreeInOrder);
        return root;
    }


}
