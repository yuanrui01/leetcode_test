package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/22-23:34
 */
public class FindDistance {

    public static void main(String[] args) {
        //构造测试数据
        TreeNode root = new TreeNode(3,new TreeNode(5,new TreeNode(6),new TreeNode(2,new TreeNode(7),new TreeNode(4))),new TreeNode(1,new TreeNode(0),new TreeNode(8)));

        findDistance(root,5, 7);
    }

    public static int findDistance(TreeNode root, int p, int q) {
        //求出节点p的路径
        List<Integer> pathp = writePath(root, p);
        //求出节点q的路径
        List<Integer> pathq = writePath(root, q);

        //求出两个节点的最近公共父节点（也就是求两个List的最长公共部分）
        //注意以下基于节点数计算，后面需要变化为路径长度
        int pathp_len = pathp.size();
        int pathq_len = pathq.size();

        int ans = 0;//最终答案
        int itr_len = Math.min(pathp_len, pathq_len);
        for(int i = 0; i < itr_len; ++i){
            if(pathp.get(i).equals(pathq.get(i))){
                ans++;
            }else{
                break;
            }
        }

        //从公共节点分别到两目标节点之和
        ans = (pathp_len - ans) + (pathq_len - ans);
        return ans;
    }

    /**
     * 记录root中，从根节点到目标节点之间的路径
     * @param root
     * @param target
     * @return
     */
    public static List<Integer> writePath(TreeNode root, int target){
        Stack<Integer> path = new Stack<>();
        dfs(root, target, path);
        //System.out.println(Arrays.toString(path.toArray()));
        return path;
    }

    /**
     * 深度优先遍历，如果某路径能找到则返回true,未找到则返回false;
     * @param root
     * @param target
     * @param path
     * @return
     */
    private static boolean dfs(TreeNode root, int target, Stack<Integer> path){
        if(root == null){
            //在其中一条路径上走到头都找不到节点则返回false
            return false;
        }

        //先把当前节点值push进去，记录路径
        path.push(root.val);

        if(root.val ==  target){
            //如果找到了就直接返回
            return true;
        }else{
            //正常写法，应该不用解释
            if(root.left != null && dfs(root.left,target,path)){
                return true;
            }
            if(root.right != null && dfs(root.right,target,path)){
                return true;
            }
        }

        //找不到的会走到这个分支，判断栈是否为空，不为空则"恢复现场"
        if(!path.isEmpty()){
            path.pop();
        }

        //未找到数据
        return false;
    }
}
