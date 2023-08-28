package com.yuanrui.leetcode;

/**
 * 2331. 计算布尔二叉树的值
 */
public class EvaluateTree {

    public boolean evaluateTree(TreeNode root) {
        return postOrderTraversal(root);
    }

    private boolean postOrderTraversal(TreeNode root) {
        if (root.left == null && root.right == null)
            return root.val == 1;
        if (root.val == 2)
            return postOrderTraversal(root.left) || postOrderTraversal(root.right);
        else
            return postOrderTraversal(root.left) && postOrderTraversal(root.right);
    }
}
