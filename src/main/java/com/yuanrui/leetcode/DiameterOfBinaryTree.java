package com.yuanrui.leetcode;

/**
 * 543. 二叉树的直径
 * @author: yuanrui
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        else
            return Math.max(depth(root.left) + depth(root.right), Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        else
            return Math.max(depth(root.left) + 1, depth(root.right) + 1);
    }
}
