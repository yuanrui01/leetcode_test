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
        max = Integer.MIN_VALUE;
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
        return Math.max(max, 1);
    }

    private int dp(int root) {
        if (map.get(root) == null)
            return 1;
        int ans = 0;
        char rootChar = s.charAt(root);
        List<Integer> children = map.get(root);
        int first = -1;
        int second = -1;
        for (Integer child : children) {
            int subMax = dp(child);
            if (rootChar != s.charAt(child)) {
                if (subMax > first) {
                    second = first;
                    first = subMax;
                } else if (subMax <= first && subMax > second) {
                    second = subMax;
                }
            }
        }
        if (first > -1 && second == -1) {
            ans = first + 1;
            max = Math.max(max, ans);
        } else if (second > -1){
            ans = first + 1;
            max = Math.max(max, ans + second);
        } else {
            max = Math.max(max, 1);
        }
        return Math.max(1, ans);
    }

    public static void main(String[] args) {
        int[] parent = {-1,0,1};
        String s = "aab";
        LongestPath longestPath = new LongestPath();
        System.out.println(longestPath.longestPath(parent, s));;
    }
}
