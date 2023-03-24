package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/24-23:57
 */
public class PreorderTraversal {

    private static List<Integer> il;
    public List<Integer> preorderTraversal(TreeNode root) {
        il = new ArrayList<>();
        if(root != null){
            il.add(root.val);
            preorder(root);
        }
        return il;
    }

    void preorder(TreeNode root){
        if(root.left!=null){
            il.add(root.left.val);
            preorder(root.left);
        }
        if(root.right!=null){
            il.add(root.right.val);
            preorder(root.right);
        }
    }
}
