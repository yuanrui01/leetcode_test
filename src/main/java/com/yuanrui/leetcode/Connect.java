package com.yuanrui.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/4-23:42
 */
public class Connect {

    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        List<Node> nodeList = new ArrayList<>();
        int idx = 1;
        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()){
            Node poll = nodeQueue.poll();
            nodeList.add(poll);
            if(poll.left != null){
                nodeQueue.add(poll.left);
            }
            if(poll.right != null){
                nodeQueue.add(poll.right);
            }
        }

        for(int i = 0; i < nodeList.size(); ++i){
            if((i+1) == 1 || ((i+2)&(i+1)) == 0){
                nodeList.get(i).next = null;
            }else{
                nodeList.get(i).next = nodeList.get(i).next.next;
            }
        }

        return root;
    }
}
