package com.yuanrui.leetcode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * @author: yuanrui
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ill = new ArrayList<>();
        if (root == null)
            return ill;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean reverse = false;
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
            if (reverse)
                Collections.reverse(layer);
            ill.add(layer);
            reverse = !reverse;
        }

        return ill;
    }
}
