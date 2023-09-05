package com.yuanrui.leetcode;

/**
 * 938. 二叉搜索树的范围和
 * @author: yuanrui
 */
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] ans = new int[1];
        traversal(root ,low, high, ans);
        return ans[0];
    }


    public static void traversal(TreeNode root, int low, int high, int[] ans) {
        if (root == null)
            return;
        if (root.val >= low && root.val <= high)
            ans[0] += root.val;
        traversal(root.left, low, high, ans);
        traversal(root.right, low, high, ans);
    }
}
