package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 513. 找树左下角的值
 * @author: yuanrui
 */
public class FindBottomLeftValue {

    /**
     * 先序遍历
     * 返回二叉树左视图的最后一个节点即可
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        buildLeftView(root, 0, ans);
        return ans.get(ans.size() - 1);
    }

    private void buildLeftView(TreeNode root, int height, List<Integer> ans) {
        if (height == ans.size())
            ans.add(root.val);
        if (root.left != null)
            buildLeftView(root.left, height + 1, ans);
        if (root.right != null)
            buildLeftView(root.right, height + 1, ans);
    }
}
