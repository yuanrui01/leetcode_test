package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * 1039. 多边形三角剖分的最低得分
 * @author: yuanrui
 */
public class MinScoreTriangulation {

    private int[] v;
    private int[][] cache;

    public int minScoreTriangulation(int[] values) {
        cache = new int[50][50];
        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }
        v = values;
        return dp(0, values.length - 1);
    }

    private int dp(int i, int j) {
        if (i+1 == j)
            return 0;
        if (cache[i][j] != -1)
            return cache[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i+1; k < j; ++k) {
            ans = Math.min(ans, dp(i,k)+dp(k, j) + v[i]*v[j]*v[k]);
        }
        return cache[i][j] = ans;
    }
}
