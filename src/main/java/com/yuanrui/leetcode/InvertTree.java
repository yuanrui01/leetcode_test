package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/5-0:14
 */
public class InvertTree {
    private static int temp;
    public static void main(String[] args) {
        invertTree(new TreeNode(1,new TreeNode(2),null));
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root != null)
            swap(root, root);
        return root;
    }

    public static void swap(TreeNode r1, TreeNode r2) {
        temp = r1.val;
        r1.val = r2.val;
        r2.val = temp;
        if(r1.left != null && r2.right != null)
            swap(r1.left, r2.right);
        if(r1 != r2 && r1.right != null && r2.left != null)
            swap(r1.right, r2.left);

        //处理交换节点有一个是空的的情况
        if(r1.left == null && r2.right != null){
            r1.left = r2.right;
            r2.right = null;
            swap(r1.left, r1.left);
        }else if(r1.left != null && r2.right == null){
            r2.right = r1.left;
            r1.left = null;
            swap(r2.right, r2.right);
        }
        if(r1 != r2){
            if(r1.right != null && r2.left == null){
                r2.left = r1.right;
                r1.right = null;
                swap(r2.left, r2.left);
            }else if(r1.right == null && r2.left != null){
                r1.right = r2.left;
                r2.left = null;
                swap(r1.right, r1.right);
            }
        }
    }
}
