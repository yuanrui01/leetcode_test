package com.yuanrui.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 543. 二叉树的直径
 * @author: yuanrui
 */
public class DiameterOfBinaryTree {

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int leftDepth = depth(root.left);
            int rightDepth = depth(root.right);
            max = Math.max(max, leftDepth + rightDepth);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
