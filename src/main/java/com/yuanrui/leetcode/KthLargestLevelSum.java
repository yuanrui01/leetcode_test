package com.yuanrui.leetcode;

import java.util.*;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/5-10:49
 */
public class KthLargestLevelSum {

    public long kthLargestLevelSum(TreeNode root, int k) {
        //结果列表
        List<List<Integer>> ill = new ArrayList<>();
        if(root == null){
            return -1;
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

        if(ill.size() < k){
            return -1;
        }else{
            List<Long> sumList = new ArrayList<>();

           for(int i = 0; i < ill.size(); ++i){
               long sum = 0;
               List<Integer> curList = ill.get(i);
               for(int j = 0; j < curList.size(); ++j){
                   sum += curList.get(j);
               }
               sumList.add(sum);
           }
           long ksum = 0l;
           long[] sumArr = sumList.stream().mapToLong(Long::valueOf).toArray();
           Arrays.sort(sumArr);
           return sumArr[sumArr.length - k];
        }
    }
}
