package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/5-22:16
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        else
            return hasPathSum2(root, targetSum - root.val);
    }

    private boolean hasPathSum2(TreeNode root, int targetSum) {
        if(root.left == null && root.right == null && targetSum == 0)
            return true;
        if(root.left != null && hasPathSum2(root.left, targetSum - root.left.val))
            return true;
        if(root.right != null && hasPathSum2(root.right, targetSum - root.right.val))
            return true;
        return false;
    }
}
