package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * @author: yuanrui
 */
public class MinDistance {
    private char[] s, t;
    private int[][] cache;

    public int minDistance(String word1, String word2) {
        s = word1.toCharArray();
        t = word2.toCharArray();
        int n = s.length, m = t.length;
        cache = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(cache[i], -1); // -1 表示没有访问过
        return dfs(n - 1, m - 1);
    }

    private int dfs(int i, int j) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        if (cache[i][j] != -1) return cache[i][j];
        if (s[i] == t[j]) return cache[i][j] = dfs(i - 1, j - 1);
        return cache[i][j] = Math.min(Math.min(dfs(i, j - 1), dfs(i - 1, j)), dfs(i - 1, j - 1)) + 1;
    }
}
