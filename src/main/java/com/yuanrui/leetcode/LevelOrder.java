package com.yuanrui.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * @author: yuanrui
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        levelOrder(root);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ill = new ArrayList<>();
        if (root == null)
            return ill;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> layer = new ArrayList<>();
            while (len > 0) {
                TreeNode head = queue.poll();
                layer.add(head.val);
                if (head.left != null)
                    queue.add(head.left);
                if (head.right != null)
                    queue.add(head.right);
                len--;
            }
            ill.add(layer);
        }

        return ill;
    }
}
