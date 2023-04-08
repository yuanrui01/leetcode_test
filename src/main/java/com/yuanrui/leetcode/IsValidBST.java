package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/8-10:05
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        else
            return isValidBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long left, long right){
        if(root == null)
            return true;
        long val = root.val;
        return val > left && val < right &&
                isValidBST(root.left, left, val) && isValidBST(root.right, val, right);
    }
}
