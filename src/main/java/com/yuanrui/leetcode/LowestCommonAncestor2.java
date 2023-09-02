package com.yuanrui.leetcode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * @author: yuanrui
 */
public class LowestCommonAncestor2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rootVal = root.val;

        if (rootVal > p.val && rootVal > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (rootVal < p.val && rootVal < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
}
