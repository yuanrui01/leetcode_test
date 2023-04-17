package com.yuanrui.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/17-21:27
 */
public class IsSubtree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();

        treeNodeQueue.add(root);
        while(!treeNodeQueue.isEmpty()){
            TreeNode first = treeNodeQueue.poll();
            if(first.val == subRoot.val && isSameTree(first,subRoot)){
                return true;
            }
            if (first.left != null)
                treeNodeQueue.add(first.left);
            if (first.right != null)
                treeNodeQueue.add(first.right);
        }

        return false;
    }

    private boolean isSameTree(TreeNode t1, TreeNode t2){
        if(t1 == t2) {
            return true;
        } else if (t1 != null && t2 == null) {
            return false;
        } else if (t1 == null && t2 != null) {
            return false;
        } else if (t1.val == t2.val && isSameTree(t1.left,t2.left) && isSameTree(t1.right,t2.right)) {
            return true;
        }
        return false;
    }
}
