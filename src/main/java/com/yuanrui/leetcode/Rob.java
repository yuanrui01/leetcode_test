package com.yuanrui.leetcode;

/**
 * 337. 打家劫舍 III
 * @author: yuanrui
 */
public class Rob {

    public int rob(TreeNode root) {
        int[] ans = dp(root);
        return Math.max(ans[0], ans[1]);
    }
    private int[] dp(TreeNode root) {
        if (root == null)
            return new int[]{0,0};
        int[] leftAns = dp(root.left);
        int[] rightAns = dp(root.right);
        int robAns = root.val + leftAns[1] + rightAns[1];
        int notRobAns = Math.max(leftAns[0], leftAns[1]) + Math.max(rightAns[0], rightAns[1]);
        return new int[]{robAns, notRobAns};
    }
}
