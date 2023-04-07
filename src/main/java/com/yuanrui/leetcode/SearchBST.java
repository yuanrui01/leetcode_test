package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/7-23:30
 */
public class SearchBST {

    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }else{
            if(root.val == val){
                return root;
            }else{
                return searchBST(root.left,val) == null ? null : searchBST(root.right,val);
            }
        }
    }
}
