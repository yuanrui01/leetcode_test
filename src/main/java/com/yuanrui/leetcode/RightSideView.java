package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuanrui
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        solve(root, ans, 0);

        return ans;
    }

    private static void solve(TreeNode root, List<Integer> ans, int height) {
        if (root != null) {
            if (height == ans.size())
                ans.add(root.val);
            solve(root.right, ans, height + 1);
            solve(root.left, ans, height + 1);
        }
    }
}
