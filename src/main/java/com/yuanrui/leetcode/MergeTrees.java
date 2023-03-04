package com.yuanrui.leetcode;


/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/4-23:28
 */
public class MergeTrees {

    public static void main(String[] args) {

    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);

        return root1;
    }
}
