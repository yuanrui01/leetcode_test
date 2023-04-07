package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/7-23:30
 */
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        else
            return (root.val > val) ? searchBST(root.left,val) : ((root.val < val) ? searchBST(root.right,val) : root);
    }
}
