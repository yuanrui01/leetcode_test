package com.yuanrui.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 783. 二叉搜索树节点最小距离
 */
public class MinDiffInBST {

    public int minDiffInBST(TreeNode root) {
        int res = Integer.MAX_VALUE;
        List<Integer> ilist = new ArrayList<>();
        if (root != null)
            inOrderTraversal(ilist, root);
        if (ilist.size() == 1) {
            return 0;
        }
        for (int i = 0; i < ilist.size() - 1; ++i) {
            if (ilist.get(i + 1) - ilist.get(i) < res)
                res = ilist.get(i + 1) - ilist.get(i);
        }

        return res;
    }

    private void inOrderTraversal(List<Integer> ilist, TreeNode root) {
        if (root.left != null)
            inOrderTraversal(ilist, root.left);
        ilist.add(root.val);
        if (root.right != null)
            inOrderTraversal(ilist, root.right);
    }
}
