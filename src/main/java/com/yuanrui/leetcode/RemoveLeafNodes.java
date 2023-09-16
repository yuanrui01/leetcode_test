package com.yuanrui.leetcode;

/**
 * 1325. 删除给定值的叶子节点
 * @author: yuanrui
 */
public class RemoveLeafNodes {

    private int target;

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        this.target = target;
        return traversal(root) ? null : root;
    }

    private boolean traversal(TreeNode root) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == target)
            return true;
        if (traversal(root.left))
            root.left = null;
        if (traversal(root.right))
            root.right = null;
        return root.left == null && root.right == null && root.val == target;
    }
}
