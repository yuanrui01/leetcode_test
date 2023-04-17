package com.yuanrui.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Connect2 {

    public static void main(String[] args) {
        System.out.println(connect(new Node(1,new Node(2,new Node(4),new Node(5)),new Node(3,null,new Node(7)))));
    }

    public static Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> nodeQueue = new ArrayDeque<>();
        List<Node> nodeList = new ArrayList<>();
        Queue<Node> temp = new ArrayDeque<>();
        root.next = null;
        nodeQueue.add(root);

        //当前队列不为空就一直加
        while (!nodeQueue.isEmpty()){
            while (!nodeQueue.isEmpty()){
                Node curNode = nodeQueue.poll();
                if(curNode.left != null){
                    nodeList.add(curNode.left);
                    temp.add(curNode.left);
                }
                if (curNode.right != null){
                    nodeList.add(curNode.right);
                    temp.add(curNode.right);
                }
            }
            if (!nodeList.isEmpty()){
                for (int i = 0; i < nodeList.size() - 1; ++i){
                    nodeList.get(i).next = nodeList.get(i + 1);
                }
                nodeList.get(nodeList.size() - 1).next = null;
            }
            nodeQueue = temp;
            nodeList.clear();
            temp = new ArrayDeque<>();
        }

        return root;
    }
}
