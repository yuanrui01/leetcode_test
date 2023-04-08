package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/9-2:07
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target){
        List<TreeNode> res = new ArrayList<>();
        res.add(root);
        while(root != target){
            if(root.val < target.val){
                root = root.right;
            } else {
                root = root.left;
            }
            res.add(root);
        }

        return res;
    }
}
