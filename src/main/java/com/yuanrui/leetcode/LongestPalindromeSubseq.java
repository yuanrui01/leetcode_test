package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * 516. 最长回文子序列
 * @author: yuanrui
 */
public class LongestPalindromeSubseq {


    private char[] s;
    private int[][] cache;

    public int longestPalindromeSubseq(String S) {
        s = S.toCharArray();
        int n = s.length;
        cache = new int[n][n];
        for (int i = 0; i < n; ++i)
            Arrays.fill(cache[i], -1); // -1 表示还没有计算过
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i > j) return 0; // 空串
        if (i == j) return 1; // 只有一个字母
        if (cache[i][j] != -1) return cache[i][j];
        if (s[i] == s[j]) return cache[i][j] = dfs(i + 1, j - 1) + 2; // 都选
        return cache[i][j] = Math.max(dfs(i + 1, j), dfs(i, j - 1)); // 枚举哪个不选
    }
}
