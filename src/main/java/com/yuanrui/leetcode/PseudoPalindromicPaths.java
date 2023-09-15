package com.yuanrui.leetcode;

import java.util.Stack;

/**
 * 1457. Pseudo-Palindromic Paths in a Binary Tree
 * @author: yuanrui
 */
public class PseudoPalindromicPaths {

    private int[] count;
    private int ans;

    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null)
            return ans;
        count = new int[9];
        traversal(root);
        return ans;
    }

    private void traversal(TreeNode root) {
        count[root.val]++;
        if (root.left != null)
            traversal(root.left);
        if (root.right != null)
            traversal(root.right);
        if (root.left == null && root.right == null)
            checkPath();
        count[root.val]--;
    }

    private void checkPath() {
        int oddCount = 0;
        for (int j : count)
            if (j % 2 != 0)
                oddCount++;
        if (oddCount <= 1)
            ans++;
    }
}
