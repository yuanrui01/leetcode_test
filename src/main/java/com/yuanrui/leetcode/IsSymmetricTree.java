package com.yuanrui.leetcode;

import java.sql.SQLOutput;
import java.util.*;

public class IsSymmetricTree {

}

class Solution {
    public boolean isSymmetric(TreeNode root) {

        if(root.left == null && root.right == null){
            return true;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode tmp = new TreeNode(101);
        //tree's depth
        int depth =maxDepth(root);
        //do something and add child to queue;
        int targetSize = (1 << depth) - 1;
        int idx = 0;
        int[] nodeArr = new int[targetSize];
        nodeQueue.add(root);
        targetSize--;

        while(!nodeQueue.isEmpty()){
            TreeNode head = nodeQueue.poll();
            nodeArr[idx++] = head.val;
            if(head == null) {
                if(targetSize > 0){
                    nodeQueue.add(tmp);
                    nodeQueue.add(tmp);
                    targetSize = targetSize - 2;
                }
            }else {
                if(targetSize > 0){
                    nodeQueue.add(head.left == null ? tmp : head.left);
                    nodeQueue.add(head.right == null ? tmp : head.right);
                    targetSize = targetSize - 2;
                }
            }
        }
        for(int i = 1; i < depth; ++i){
            //检查每一层是否对称
            int startIdx = (1 << i) - 1;
            int endIdx = (1 << (i+1)) - 2;
            while(startIdx < endIdx){
                if(nodeArr[startIdx] != nodeArr[endIdx])
                    return false;
                startIdx++;
                endIdx--;
            }
        }

        return true;
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    private int max(int a, int b){
        if(a > b){
            return a;
        }else{
            return b;
        }
    }
}
