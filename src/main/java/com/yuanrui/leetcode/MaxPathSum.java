package com.yuanrui.leetcode;

/**
 * 124. 二叉树中的最大路径和
 * @author: yuanrui
 */
public class MaxPathSum {
    int ans;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dp(root);
        return ans;
    }

    private int dp(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int leftMax = dp(root.left);
            int rightMax = dp(root.right);
            ans = Math.max(Math.max(ans,root.val), (Math.max(leftMax, 0)) + (Math.max(rightMax, 0)) + root.val);
            return Math.max(root.val, Math.max(leftMax,rightMax) + root.val);
        }
    }
}
