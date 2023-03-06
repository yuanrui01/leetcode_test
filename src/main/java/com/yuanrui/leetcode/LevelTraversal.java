package com.yuanrui.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //结果列表
        List<List<Integer>> ill = new ArrayList<>();
        if(root == null){
            return ill;
        }
        //准备两个队列，
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        Queue<TreeNode> swapQueue = new ArrayDeque<>();
        queue1.add(root);

        while(!queue1.isEmpty()){
            List<Integer> il = new ArrayList<>();
            while(!queue1.isEmpty()){
                TreeNode poll = queue1.poll();
                il.add(poll.val);
                if(poll.left != null){
                    queue2.add(poll.left);
                }
                if(poll.right != null){
                    queue2.add(poll.right);
                }
            }
            //一层结束，加入结果
            ill.add(il);
            //交换queue1、queue2
            swapQueue = queue1;
            queue1 = queue2;
            queue2 = swapQueue;
        }

        return ill;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
