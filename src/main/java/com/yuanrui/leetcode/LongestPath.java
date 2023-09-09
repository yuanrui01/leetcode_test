package com.yuanrui.leetcode;

import java.util.*;

/**
 * 2246. 相邻字符不同的最长路径
 * @author: yuanrui
 */
public class LongestPath {

    Map<Integer, List<Integer>> map;
    String s;
    int max;
    public int longestPath(int[] parent, String s) {
        map = new HashMap<>();
        max = 1;
        this.s = s;

        // 构造节点关系
        for (int i = 1; i < parent.length; ++i) {
            if (map.get(parent[i]) != null) {
                map.get(parent[i]).add(i);
            } else {
                List<Integer> children = new ArrayList<>();
                children.add(i);
                map.put(parent[i], children);
            }
        }
        dp(0);
        return max;
    }

    private int dp(int root) {
        if (map.get(root) == null)
            return 1;
        char rootChar = s.charAt(root);
        int maxLen = 0;
        for (Integer child : map.get(root)) {
            int subMax = dp(child);
            if (rootChar != s.charAt(child)) {
                max = Math.max(max, maxLen + subMax + 1);
                maxLen = Math.max(maxLen, subMax);
            }
        }
        return maxLen + 1;
    }

    public static void main(String[] args) {
        int[] parent = {-1,0,1};
        String s = "aab";
        LongestPath longestPath = new LongestPath();
        System.out.println(longestPath.longestPath(parent, s));;
    }
}
