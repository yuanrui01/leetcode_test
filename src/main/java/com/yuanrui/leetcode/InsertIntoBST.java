package com.yuanrui.leetcode;

import com.sun.source.tree.Tree;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/9-2:44
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode pos = root;
        while(pos != null){
            if(pos.val > val){
                if(pos.left == null){
                    pos.left = new TreeNode(val);
                    break;
                }else{
                    pos = pos.left;
                }
            }else{
                if(pos.right == null){
                    pos.right = new TreeNode(val);
                    break;
                }else{
                    pos = pos.right;
                }
            }
        }
        return root;
    }
}
