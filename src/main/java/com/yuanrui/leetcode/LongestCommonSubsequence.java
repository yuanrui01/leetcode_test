package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * 1143. 最长公共子序列
 */
public class LongestCommonSubsequence {
    private char[] s, t;
    private int[][] cache;

    /**
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     */
    public int longestCommonSubsequence(String text1, String text2) {
        s = text1.toCharArray();
        t = text2.toCharArray();
        int n = s.length, m = t.length;
        cache = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(cache[i], -1); // -1 表示没有访问过
        return dfs(n - 1, m - 1);
    }

    private int dfs(int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (cache[i][j] != -1) return cache[i][j];
        if (s[i] == t[j]) return cache[i][j] = dfs(i - 1, j - 1) + 1;
        return cache[i][j] = Math.max(dfs(i - 1, j), dfs(i, j - 1));
    }
}
