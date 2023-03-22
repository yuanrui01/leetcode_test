package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/22-23:34
 */
public class FindDistance {

    public int findDistance(TreeNode root, int p, int q) {

    }


    /**
     *
     */
    public List<Integer> writePath(TreeNode root, int target){
        List<Integer> path = new ArrayList<>();
        Stack<Integer> path = new Stack<>();


        return path;`
    }

    private boolean dfs(TreeNode root, int target, Stack<Integer> path){
        if(root == null){
            return false;
        }
        if(root.val ==  target){
            path.push(target);
            return true;
        }else{
            path.push(root.val);
            if(root.left != null){
                dfs(root.left,target,path);
            }
            if(root.left != null){
                dfs(root.left,target,path);
            }
        }
    }
}
