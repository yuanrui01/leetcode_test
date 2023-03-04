package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/4-23:29
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
